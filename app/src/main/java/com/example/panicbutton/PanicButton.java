package com.example.panicbutton;

public class PanicButton {
    
    //Number for Shining Rock (development device)
    private static final String SHINING_ROCK_PHONE_NUMBER = "tel:+1-336-416-5446";
    
    private int panicButtonIndex;    //Index of PanicButton in panicButtonList in Globals class
    private String panicButtonName;
    private String panicButtonRecipient;
    private String panicButtonPhoneNumber;
    private String panicButtonType;
    private String panicButtonMsg;

    public PanicButton(int buttonIndex, String buttonName, String buttonRecipient, String buttonPhoneNumber, String buttonType) {
        this.panicButtonIndex = buttonIndex;
        this.panicButtonName = buttonName;
        this.panicButtonRecipient = buttonRecipient;
//        this.panicButtonPhoneNumber = buttonPhoneNumber;
        this.panicButtonPhoneNumber = SHINING_ROCK_PHONE_NUMBER;
        this.panicButtonType = buttonType;
    }

    public PanicButton(int buttonIndex, String buttonName, String buttonRecipient, String buttonPhoneNumber, String buttonType, String buttonMsg) {
        this.panicButtonIndex = buttonIndex;
        this.panicButtonName = buttonName;
        this.panicButtonRecipient = buttonRecipient;
//        this.panicButtonPhoneNumber = buttonPhoneNumber;
        this.panicButtonPhoneNumber = SHINING_ROCK_PHONE_NUMBER;
        this.panicButtonType = buttonType;
        this.panicButtonMsg = buttonMsg;
    }

    public int getPanicButtonIndex() {
        return panicButtonIndex;
    }

    public String getPanicButtonName() {
        return panicButtonName;
    }

    public String getPanicButtonRecipient() {
        return panicButtonRecipient;
    }

    public String getPanicButtonPhoneNumber() {
        return panicButtonPhoneNumber;
    }

    public String getPanicButtonType() {
        return panicButtonType;
    }
    
    public String getPanicButtonMsg() {
        return panicButtonMsg;
    }

    public void setPanicButtonIndex(int panicButtonIndex) {
        this.panicButtonIndex = panicButtonIndex;
    }

    public void setPanicButtonName(String panicButtonName) {
        this.panicButtonName = panicButtonName;
    }

    public void setPanicButtonRecipient(String panicButtonRecipient) {
        this.panicButtonRecipient = panicButtonRecipient;
    }

    public void setPanicButtonPhoneNumber(String panicButtonPhoneNumber) {
        this.panicButtonPhoneNumber = panicButtonPhoneNumber;
    }

    public void setPanicButtonType(String panicButtonType) {
        this.panicButtonType = panicButtonType;
    }
    
    public void setPanicButtonMsg(String panicButtonMsg) {
        this.panicButtonMsg = panicButtonMsg;
    }
}
