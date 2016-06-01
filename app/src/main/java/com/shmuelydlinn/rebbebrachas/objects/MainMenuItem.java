package com.shmuelydlinn.rebbebrachas.objects;

/**
 * Created by shmueldlinn on 5/30/16.
 * Object that houses the values of the main menu items
 */

public class MainMenuItem {
    private final String text;

    /**
     *
     * @param text
     */
    public MainMenuItem(String text){
        this.text = text;
    }

    /**
     * 
     * @return
     */
    public String getText() {
        return text;
    }

}
