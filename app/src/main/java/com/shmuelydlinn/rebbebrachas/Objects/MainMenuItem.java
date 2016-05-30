package com.shmuelydlinn.rebbebrachas.Objects;

/**
 * Created by shmueldlinn on 5/30/16.
 * Object that houses the values of the main menu items
 */

public class MainMenuItem {
    String text;

    public MainMenuItem(){
    }

    public MainMenuItem(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
