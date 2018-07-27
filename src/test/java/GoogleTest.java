import configuration.Configuration;
import driver.Driver;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

   @Test
   public void googleTest() {
      Driver.getInstance().get(Configuration.getProperty("webViewTestURL"));
      System.out.println("OK");
   }
}
