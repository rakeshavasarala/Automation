package com.actions;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public final class PageActions {

    public enum SelectTypes {
        TEXT,
        VALUE,
        INDEX
    }

    /**
     * For Text Fields
     *
     * @param element
     * @param value
     */
    public void enterText(WebElement element, java.lang.CharSequence... value) {
        element.sendKeys(value);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void submit(WebElement element) {
        element.submit();
    }


    public void selectCheckBox(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }


    public void unSelectCheckBox(WebElement element) {
        if (element.isSelected()) {
            element.click();
        }
    }


    public void selectFromDropDown(WebElement element, String valueOrText, SelectTypes selectType) {
        selectFromDropDown(new Select(element), valueOrText, selectType);
    }


    public void selectFromDropDown(Select select, String valueOrText, SelectTypes selectType) {
        switch (selectType) {
            case TEXT:
                select.selectByVisibleText(valueOrText);
                break;
            case VALUE:
                select.selectByValue(valueOrText);
                break;
            case INDEX:
                select.selectByIndex(Integer.parseInt(valueOrText));
                break;
            default:
                break;
        }
    }


}
