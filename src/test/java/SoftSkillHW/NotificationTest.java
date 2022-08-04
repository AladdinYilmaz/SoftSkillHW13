package SoftSkillHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class NotificationTest extends TestBase{

@Test
    public void notification01() throws InterruptedException {
        WebElement userIcon = driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-menu-trigger user-button mat-button mat-button-base ng-star-inserted']"));
        userIcon.click();
        Thread.sleep(2000);
        WebElement settingsIcon = driver.findElement(By.xpath("//*[@id=\"mat-menu-panel-0\"]/div/button[3]"));
        settingsIcon.click();
        Thread.sleep(2000);
        WebElement notification = driver.findElement(By.xpath("//*[@id=\"mat-tab-label-0-1\"]/div"));
        notification.click();
        Thread.sleep(2000);

        WebElement ExtraLessonAddedViaEmail = driver.findElement(By.xpath("//*[@id=\"mat-slide-toggle-2\"]"));
        ExtraLessonAddedViaEmail.click();
        Thread.sleep(2000);
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"mat-dialog-1\"]/profile-dialog/ms-dialog/ms-dialog-buttons/mat-dialog-actions/ms-save-button"));
        saveButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Profile successfully updated']")));
        WebElement textSuccess = driver.findElement(By.xpath("//*[text()='Profile successfully updated']"));
        //System.out.println("test result message   "+textSuccess.getText());
        String expectedTextSuccess="Profile successfully updated";
        Assert.assertEquals(textSuccess.getText(),expectedTextSuccess);

    }


}
