package com.school.controller;

import com.school.entity.UlockApplication;
import com.school.entity.UlockApplicationWithBLOBs;
import com.school.entity.UlockOperator;
import com.school.service.UlockApplicationService;
import com.school.service.UlockOperatorService;
import org.apache.catalina.manager.util.SessionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by chendonglin on 2018/4/29.
 */
@RequestMapping("/support")
@Controller
public class UnlockController {

    @Autowired
    private UlockApplicationService ulockApplicationService;

    @Autowired
    private UlockOperatorService ulockOperatorService;


    @RequestMapping("/unlock")
    public String unlockHomePage() {
        return "unlock";
    }

    @RequestMapping("/help")
    public String help() {
        return "help";
    }


    @RequestMapping("/application")
    public String application() {
        return "application";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(UlockApplicationWithBLOBs application, @RequestParam("photos") MultipartFile[] photos) throws IOException {
        application.setIdPhoto(photos[0].getBytes());
        application.setPackagePhoto(photos[1].getBytes());
        application.setBillPhoto((photos[2].getBytes()));
        ulockApplicationService.insert(application);
        return "redirect:/index";
    }

    @RequestMapping("/application/index")
    public String applicationIndex() {
        return "application0";
    }

    @RequestMapping("/application1/index")
    public String application1Index() {
        return "application1";
    }

    @RequestMapping("/application2/index")
    public String applicationIndex2() {
        return "application2";
    }


    @ResponseBody
    @RequestMapping("/application/data")
    public List<UlockApplication> applicationData() {

        List<UlockApplication> applications = ulockApplicationService.getApplicationByState(0);

        return applications;
    }

    @ResponseBody
    @RequestMapping("/application1/data")
    public List<UlockApplication> application1Data() {

        List<UlockApplication> applications = ulockApplicationService.getApplicationByState(1);

        return applications;
    }

    @ResponseBody
    @RequestMapping("/application2/data")
    public List<UlockApplication> application2Data() {

        List<UlockApplication> applications = ulockApplicationService.getApplicationByState(2);

        return applications;
    }

    @RequestMapping("/judge")
    public String applicationJudge(@RequestParam("id") long id, Model model) {
        UlockApplicationWithBLOBs applicationWithBLOBs = ulockApplicationService.getApplication(id);
        model.addAttribute("imei", applicationWithBLOBs.getImei1());
        model.addAttribute("sno", applicationWithBLOBs.getSno());
        model.addAttribute("unlockId", applicationWithBLOBs.getUnlockId());
        model.addAttribute("tel", applicationWithBLOBs.getTel());
        model.addAttribute("id", applicationWithBLOBs.getId());
        return "applicationJudge";
    }


    @RequestMapping("/judge/photo")
    public void applicationBillPhoto(@RequestParam("id") long id, @RequestParam("photo") int photo, HttpServletRequest request, HttpServletResponse response) {
        UlockApplicationWithBLOBs applicationWithBLOBs = ulockApplicationService.getApplication(id);
        byte[] contents = null;
        switch (photo) {
            case 0:
                contents = applicationWithBLOBs.getIdPhoto();
                break;
            case 1:
                contents = applicationWithBLOBs.getPackagePhoto();
                break;
            case 2:
                contents = applicationWithBLOBs.getBillPhoto();
                break;
        }
        ServletOutputStream out = null;

        try {
            InputStream is = new ByteArrayInputStream(contents);
            response.setContentType("image/*");
            out = response.getOutputStream();
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = is.read(buf, 0, 1024)) != -1) {
                out.write(buf, 0, len);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Transactional
    @RequestMapping("/judge/{result}")
    public String applicationResult(@RequestParam("id") long id, @PathVariable("result") int result) {

        UlockApplicationWithBLOBs ulockApplication = new UlockApplicationWithBLOBs();
        ulockApplication.setId(id);
        ulockApplication.setState(result + 1);
        ulockApplication.setUpdateTime(System.currentTimeMillis());
        ulockApplicationService.updateByPrimaryKeySelective(ulockApplication);

        UlockApplication ulockApplication1 = ulockApplicationService.getApplication(id);
        UlockOperator operator = new UlockOperator();
        operator.setAction(result);
        Subject subject = SecurityUtils.getSubject();
        String username = subject.getPrincipal().toString();
        operator.setOperator(username);
        operator.setUnlockId(ulockApplication1.getUnlockId());
        operator.setUpdateTime(System.currentTimeMillis());
        ulockOperatorService.insertSelective(operator);
        return "redirect:/support/application/index";
    }
}

