package com.example.panicbutton;

public class Button {
    private int buttonIDNumber;
    private String buttonName;
    private String buttonPhoneNumber;
    private String buttonType;

    public Button(int buttonIDNumber, String buttonName, String buttonPhoneNumber, String buttonType) {
        this.buttonIDNumber = buttonIDNumber;
        this.buttonName = buttonName;
        this.buttonPhoneNumber = buttonPhoneNumber;
        this.buttonType = buttonType;
    }

    public int getButtonIDNumber() {
        return buttonIDNumber;
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

    public void setButtonIDNumber(int buttonIDNumber) {
        this.buttonIDNumber = buttonIDNumber;
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
