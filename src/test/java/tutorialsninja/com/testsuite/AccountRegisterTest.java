package tutorialsninja.com.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tutorialsninja.com.pages.AccountRegisterPage;
import tutorialsninja.com.testbase.BaseTest;

public class AccountRegisterTest extends BaseTest {

    AccountRegisterPage accountRegisterPage=new AccountRegisterPage();

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        //3.1 Click on My Account Link.
      accountRegisterPage.clickOnMyAccountLink();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //3.3 Enter First Name
        accountRegisterPage.typeFirstName();
        //3.4 Enter Last Name
        accountRegisterPage.typeLastName();
        //3.5 Enter Email
        accountRegisterPage.typeEmail();
        //3.6 Enter Telephone
        accountRegisterPage.typeTelephone();
        //3.7 Enter Password
        accountRegisterPage.typePassword();
        //3.8 Enter Password Confirm
        accountRegisterPage.typeconfirmPassword();
        //3.9 Select Subscribe Yes radio button
        accountRegisterPage.clickSubscribe();
        //3.10 Click on Privacy Policy check box
        accountRegisterPage.clickOnPrivacy();
        //3.11 Click on Continue button
        accountRegisterPage.clickOnContinue();
        //3.12 Verify the message “Your Account Has Been Created!”
        verifyText(driver, By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"),"Your Account Has Been Created!");
        //3.13 Click on Continue button
        accountRegisterPage.clickOncontinue2();
        //3.14 Click on My Account Link.
        accountRegisterPage.clickOnMyAccountLink();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        verifyText(driver,By.xpath("//h1[normalize-space()='Account Logout']"),"Account Logout");
        //3.17 Click on Continue button
        accountRegisterPage.clickOncontinue2();
    }

}
