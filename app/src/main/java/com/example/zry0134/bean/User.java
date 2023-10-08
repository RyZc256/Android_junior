package com.example.zry0134.bean;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

public class User extends BmobUser {
    private BmobFile headImage;
    private boolean sex;
    private String nickName;
    private String info;

    public void setHeadImage(BmobFile headImage) {
        this.headImage = headImage;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public BmobFile getHeadImage() {
        return headImage;
    }

    public boolean isSex() {
        return sex;
    }

    public String getNickName() {
        return nickName;
    }

    public String getInfo() {
        return info;
    }
}
