package com.epam.atm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GMailDraftFolderPage extends GMailBoxPage {

    public boolean isNewMessageInDraftFolder(String subjectText) {
        WebElement newMessageInDraftFolder = (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='" + subjectText + "']")));
        return newMessageInDraftFolder.isEnabled();
    }

    public GMailMessagePage clickOnDraftMessage() {
        By draftMessage = By.xpath("*//div[@role='main']");
        WebElement draftMessageElement = webDriver.findElements(draftMessage).get(0);
        clickOnElement(draftMessageElement);
        return new GMailMessagePage();
    }

    public boolean isMessageRemoveFromDraft(String subjectText) {
        By draftMailLocator = By.xpath("//span[text()='" + subjectText + "']");
        return isElementPresent(draftMailLocator);
    }
}
