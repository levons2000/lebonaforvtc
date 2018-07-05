package com.example.levon.lebona;

public class Model {
    private String imgUrl;
    int likeCounter = 0;
    int commentCounter = 0;
    boolean isLiked = false;

    public Model(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void plusLike() {
        ++likeCounter;
    }

    public void plusComment() {
        ++commentCounter;
    }

    public void minusLike(){
        --likeCounter;
    }
}
