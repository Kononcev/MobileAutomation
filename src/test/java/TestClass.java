import business.CalculatorBO;
import driver.Driver;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass {
   private CalculatorBO calculator;

   @BeforeClass
   public void setUpDriver() {
      Driver.getInstance();
      calculator = new CalculatorBO();
   }

   @Test
   public void testPlusOperation() throws Exception {
      String expression = "11+2=13";
      String result = StringUtils.substringAfter(expression, "=");
      calculator.performExpression(expression);
      Assert.assertEquals(calculator.getResult(), result, String.format("Plus operation works wrong:\t Expected:%s\tActual:%s", result, calculator.getResult()));
   }

   @Test
   public void testMinusOperation() {
      String expression = "11-4=7";
      String result = StringUtils.substringAfter(expression, "=");
      calculator.performExpression(expression);
      Assert.assertEquals(calculator.getResult(), result, String.format("Minus operation works wrong:\t Expected:%s\tActual:%s", result, calculator.getResult()));
   }

   @AfterClass
   public void tearDown() {
      Driver.dropDriver();
   }
}
