package com.school.entity;

public class UlockOperator {
    private Long id;

    private String operator;

    private String unlockId;

    private Integer action;

    private Long updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getUnlockId() {
        return unlockId;
    }

    public void setUnlockId(String unlockId) {
        this.unlockId = unlockId == null ? null : unlockId.trim();
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}