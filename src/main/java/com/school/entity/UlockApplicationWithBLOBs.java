package com.school.entity;

public class UlockApplicationWithBLOBs extends UlockApplication {
    private byte[] idPhoto;

    private byte[] packagePhoto;

    private byte[] billPhoto;

    public byte[] getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(byte[] idPhoto) {
        this.idPhoto = idPhoto;
    }

    public byte[] getPackagePhoto() {
        return packagePhoto;
    }

    public void setPackagePhoto(byte[] packagePhoto) {
        this.packagePhoto = packagePhoto;
    }

    public byte[] getBillPhoto() {
        return billPhoto;
    }

    public void setBillPhoto(byte[] billPhoto) {
        this.billPhoto = billPhoto;
    }
}