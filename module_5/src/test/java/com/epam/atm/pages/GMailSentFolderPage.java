package com.epam.atm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GMailSentFolderPage extends GMailBoxPage {
    private static final String BTN_DELETE = "//div[@data-tooltip='Delete']";

    private By messageLocator;

    public boolean isMessageInSentFolder(String subjectText) {
        messageLocator = getMessageLocator(subjectText);
        return isElementPresent(messageLocator);
    }

    public void deleteMessageFromSentFolder(String subjectText) {
        messageLocator = getMessageLocator(subjectText);
        WebElement messageElement = webDriver.findElement(messageLocator);
        getActions()
                .click(messageElement)
                .build()
                .perform();
        By byBtnDelete = By.xpath(BTN_DELETE);
        if (isElementPresent(byBtnDelete)) {
            WebElement deleteBtn = webDriver.findElement(byBtnDelete);
            clickOnElement(deleteBtn);
        }
    }

    private By getMessageLocator(String subjectText) {
        return By.xpath("//div[@role='link']//span[text()='" + subjectText + "']");
    }
}
