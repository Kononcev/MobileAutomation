import business.CalculatorBO;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseTest {
   private CalculatorBO calculator;

   @BeforeTest
   public void setUpDriver() {
      calculator = new CalculatorBO();
   }

   @Test
   public void testPlusOperation(){
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
}
