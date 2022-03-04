package com.example.btvn_buoi4.Group;

public class GroupModel {
    private int imgResource;
    private String nameGroup;
    private int qtyFolower;
    private int qtyPost;
    private STATUS_POST status;

    public GroupModel(int imgResource, String nameGroup, int qtyFolower, int qtyPost, STATUS_POST status) {
        this.imgResource = imgResource;
        this.nameGroup = nameGroup;
        this.qtyFolower = qtyFolower;
        this.qtyPost = qtyPost;
        this.status = status;
    }

    enum STATUS_POST{
        NHOM_DONG,NHOM_KIN,NHOM_MO;
    }


    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public int getQtyFolower() {
        return qtyFolower;
    }

    public void setQtyFolower(int qtyFolower) {
        this.qtyFolower = qtyFolower;
    }

    public int getQtyPost() {
        return qtyPost;
    }

    public void setQtyPost(int qtyPost) {
        this.qtyPost = qtyPost;
    }

    public STATUS_POST getStatus() {
        return status;
    }

    public void setStatus(STATUS_POST status) {
        this.status = status;
    }
}
