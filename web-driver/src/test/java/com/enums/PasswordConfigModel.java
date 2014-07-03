package com.enums;

/**
 * Created by IntelliJ IDEA.
 * User: Rakesh Avasarala
 * Date: 7/1/14
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class PasswordConfigModel {
    private String minimumLength;

    private String numericCharactersRequired;

    private String uppercaseAlphaCharactersRequired;

    private String lowercaseAlphaCharactersRequired;

    private String specialCharactersRequired;

    private String passwordExpiryPeriod;

    private String passwordHistorySize;

    private boolean forcePasswordChangeOnFirstLogin;

    public String getMinimumLength() {
        return minimumLength;
    }

    public void setMinimumLength(String minimumLength) {
        this.minimumLength = minimumLength;
    }

    public String getNumericCharactersRequired() {
        return numericCharactersRequired;
    }

    public void setNumericCharactersRequired(String numericCharactersRequired) {
        this.numericCharactersRequired = numericCharactersRequired;
    }

    public String getUppercaseAlphaCharactersRequired() {
        return uppercaseAlphaCharactersRequired;
    }

    public void setUppercaseAlphaCharactersRequired(String uppercaseAlphaCharactersRequired) {
        this.uppercaseAlphaCharactersRequired = uppercaseAlphaCharactersRequired;
    }

    public String getLowercaseAlphaCharactersRequired() {
        return lowercaseAlphaCharactersRequired;
    }

    public void setLowercaseAlphaCharactersRequired(String lowercaseAlphaCharactersRequired) {
        this.lowercaseAlphaCharactersRequired = lowercaseAlphaCharactersRequired;
    }

    public String getSpecialCharactersRequired() {
        return specialCharactersRequired;
    }

    public void setSpecialCharactersRequired(String specialCharactersRequired) {
        this.specialCharactersRequired = specialCharactersRequired;
    }

    public String getPasswordExpiryPeriod() {
        return passwordExpiryPeriod;
    }

    public void setPasswordExpiryPeriod(String passwordExpiryPeriod) {
        this.passwordExpiryPeriod = passwordExpiryPeriod;
    }

    public String getPasswordHistorySize() {
        return passwordHistorySize;
    }

    public void setPasswordHistorySize(final String passwordHistorySize) {
        this.passwordHistorySize = passwordHistorySize;
    }

    public boolean isForcePasswordChangeOnFirstLogin() {
        return forcePasswordChangeOnFirstLogin;
    }

    public void setForcePasswordChangeOnFirstLogin(boolean forcePasswordChangeOnFirstLogin) {
        this.forcePasswordChangeOnFirstLogin = forcePasswordChangeOnFirstLogin;
    }
}
