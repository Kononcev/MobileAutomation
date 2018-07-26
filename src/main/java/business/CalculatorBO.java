package business;

import model.CalculatorPO;
import org.apache.commons.lang3.StringUtils;
import utils.CustomUtils;

import java.util.stream.IntStream;

public class CalculatorBO {
   private CalculatorPO calculator;


   public CalculatorBO() {
      this.calculator = new CalculatorPO();
   }

   public void performExpression(String fullExpression) {
      try {
         CustomUtils.verifyExpression(fullExpression);
      } catch (Exception e) {
         System.err.println("Unsupported fullExpression:" + fullExpression);
         e.printStackTrace();
      }
      String expression = StringUtils.substringBefore(fullExpression, "=");
      IntStream.range(0, expression.length()).forEach(index->calculator.performClick(expression.charAt(index)));
   }

   public String getResult(){
      return calculator.getResult();
   }
}
