package com.example.panicbutton;

public class Button {
    private String buttonName;
    private String buttonPhoneNumber;
    private String buttonType;

    public Button(String buttonName, String buttonPhoneNumber, String buttonType) {
        this.buttonName = buttonName;
        this.buttonPhoneNumber = buttonPhoneNumber;
        this.buttonType = buttonType;
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
}
