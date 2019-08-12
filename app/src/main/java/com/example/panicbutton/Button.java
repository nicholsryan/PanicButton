package com.example.panicbutton;

public class Button {
    private int buttonIndex;    //Index of Button in panicButtonList in Globals class
    private String buttonName;
    private String buttonPhoneNumber;
    private String buttonType;

    public Button(int buttonIndex, String buttonName, String buttonPhoneNumber, String buttonType) {
        this.buttonIndex = buttonIndex;
        this.buttonName = buttonName;
        this.buttonPhoneNumber = buttonPhoneNumber;
        this.buttonType = buttonType;
    }

    public int getButtonIndex() {
        return buttonIndex;
    }

    public String getButtonName() {
        return buttonName;
    }

    public String getButtonPhoneNumber() {
        return buttonPhoneNumber;
    }

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonIndex(int buttonIndex) {
        this.buttonIndex = buttonIndex;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public void setButtonPhoneNumber(String buttonPhoneNumber) {
        this.buttonPhoneNumber = buttonPhoneNumber;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
}
