package business;

import model.CalculatorPO;
import utils.CustomUtils;

public class CalculatorBO {
   private CalculatorPO calculator;


   public CalculatorBO() {
      this.calculator = new CalculatorPO();
   }

   public void performExpression(String expression) {
      try {
         CustomUtils.verifyExpression(expression);
      } catch (Exception e) {
         System.err.println("Unsupported expression:" + expression);
         e.printStackTrace();
      }
      for (int i = 0, n = expression.length(); i < n; i++) {
         calculator.performClick(expression.charAt(i));
      }
   }
}
