package tutorialsninja.com.pages;

import org.openqa.selenium.By;
import tutorialsninja.com.utilities.Utility;

public class HomePage extends Utility {

    By loginLink = By.linkText("Login");
    By registerLink = By.linkText("Register");

    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }

    public void registerLink() {
        clickOnElement(registerLink);
    }
}
