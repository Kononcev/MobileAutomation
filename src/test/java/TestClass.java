import driver.Driver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {
   AppiumDriver driver;

   @BeforeTest
   public void setUpDriver() {
      driver = Driver.getInstance();
   }

   @Test
   public void firstTest() throws Exception {
      /*capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");*/
      //capabilities.setCapability("chromedriverExecutable", "C:\\Users\\Volodymyr_konontsev\\IdeaProjects\\ei-webui-automation\\aer-lingus-uita\\wd\\versions\\chromedriver\\2.37\\chromedriver_win32//chromedriver.exe");


      //((AndroidDriver)driver).startActivity(activity);
      /*driver.get("https://www.google.com/");*/

      WebElement nine = driver.findElement(By.id("com.android.calculator2:id/digit_9"));
      WebElement three = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
      WebElement plus = driver.findElement(By.id("com.android.calculator2:id/op_add"));
      WebElement equals = driver.findElement(By.id("com.android.calculator2:id/eq"));
      WebElement result = driver.findElement(By.id("com.android.calculator2:id/result"));
      nine.click();
      plus.click();
      three.click();
      equals.click();
      System.out.println(result.getText());
      driver.quit();
   }

   @AfterClass
   public void tearDown() {
      Driver.dropDriver();
   }
}
