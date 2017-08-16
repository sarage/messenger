package com.example.aizhan.messenger;

/**
 * Created by aizhan on 8/16/17.
 */

public class Oper {
    private int operIcon;
    private String operName;

    Oper(int operIcon, String operName){
        this.operIcon=operIcon;
        this.operName=operName;
    }

    public String getOperName(){
        return operName;
    }
    public int getOperIcon(){
        return operIcon;
    }
}
