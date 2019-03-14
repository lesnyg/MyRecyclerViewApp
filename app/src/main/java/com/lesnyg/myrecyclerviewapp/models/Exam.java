package com.lesnyg.myrecyclerviewapp.models;

public class Exam {
    private int iconimage;
    private String menuText;
    private String countText;

    public Exam(int iconimage, String menuText, String countText) {
        this.iconimage = iconimage;
        this.menuText = menuText;
        this.countText = countText;
    }

    public int getIconimage() {
        return iconimage;
    }

    public void setIconimage(int iconimage) {
        this.iconimage = iconimage;
    }

    public String getMenuText() {
        return menuText;
    }

    public void setMenuText(String menuText) {
        this.menuText = menuText;
    }

    public String getCountText() {
        return countText;
    }

    public void setCountText(String countText) {
        this.countText = countText;
    }
}
