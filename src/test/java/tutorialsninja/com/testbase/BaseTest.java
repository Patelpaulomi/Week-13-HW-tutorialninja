package tutorialsninja.com.testbase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tutorialsninja.com.propertyreader.PropertyReader;
import tutorialsninja.com.utilities.Utility;

public class BaseTest extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser"); //"Chrome"
    @BeforeMethod

    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod

    public void tearDown(){
        closeBrowser();
    }

}
