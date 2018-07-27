import business.CalculatorBO;
import driver.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
   @BeforeClass
   public void setUpDriver() {
      Driver.getInstance();
   }

   @AfterClass
   public void tearDown() {
      Driver.dropDriver();
   }
}
