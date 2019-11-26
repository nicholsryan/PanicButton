package com.example.panicbutton;

public class PanicButton {
    
    //Number for Shining Rock (development device)
    private static final String SHINING_ROCK_PHONE_NUMBER_CALL = "tel:+1-336-416-5446";
    private static final String SHINING_ROCK_PHONE_NUMBER_TEXT = "sms:+1-336-416-5446";
    
    
    private int panicButtonIndex;    //Index of PanicButton in panicButtonList in Globals class
    private String panicButtonName;
    private String panicButtonRecipient;
    private String panicButtonPhoneNumber;
    private String panicButtonType;
    private String panicButtonMsg;

    public PanicButton(int panicButtonIndex, String panicButtonName, String panicButtonRecipient,
                       String panicButtonPhoneNumber, String panicButtonType) {
        this.panicButtonIndex = panicButtonIndex;
        this.panicButtonName = panicButtonName;
        this.panicButtonRecipient = panicButtonRecipient;
        this.panicButtonPhoneNumber = "tel:" + panicButtonPhoneNumber;
//        this.panicButtonPhoneNumber = SHINING_ROCK_PHONE_NUMBER_CALL;
        this.panicButtonType = panicButtonType;
    }

    public PanicButton(int panicButtonIndex, String panicButtonName, String panicButtonRecipient,
                       String panicButtonPhoneNumber, String panicButtonType, String panicButtonMsg) {
        this.panicButtonIndex = panicButtonIndex;
        this.panicButtonName = panicButtonName;
        this.panicButtonRecipient = panicButtonRecipient;
        
        if (panicButtonType.equals("Call")) {
            this.panicButtonPhoneNumber = "tel:" + panicButtonPhoneNumber;
//            this.panicButtonPhoneNumber = SHINING_ROCK_PHONE_NUMBER_CALL;
        }
        else {
            this.panicButtonPhoneNumber = "sms:" + panicButtonPhoneNumber;
//            this.panicButtonPhoneNumber = SHINING_ROCK_PHONE_NUMBER_TEXT;
        }
        
        this.panicButtonType = panicButtonType;
        this.panicButtonMsg = panicButtonMsg;
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
