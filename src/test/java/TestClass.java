import business.CalculatorBO;
import driver.Driver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass {
   private AppiumDriver driver;
   private CalculatorBO calculator;

   @BeforeClass
   public void setUpDriver() {
      driver = Driver.getInstance();
      calculator = new CalculatorBO();
   }

   @Test
   public void firstTest() throws Exception {
      /*capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");*/
      //capabilities.setCapability("chromedriverExecutable", "C:\\Users\\Volodymyr_konontsev\\IdeaProjects\\ei-webui-automation\\aer-lingus-uita\\wd\\versions\\chromedriver\\2.37\\chromedriver_win32//chromedriver.exe");


      //((AndroidDriver)driver).startActivity(activity);
      /*driver.get("https://www.google.com/");*/

      calculator.performExpression("11+2+3");

   }

   @AfterClass
   public void tearDown() {
      Driver.dropDriver();
   }
}
