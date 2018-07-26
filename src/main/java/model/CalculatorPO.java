package model;

import business.CalculatorBO;
import driver.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webelements.Button;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CalculatorPO extends PageObject {
   @FindBy(id = "com.android.calculator2:id/digit_0")
   @MyAnnotation(value = '0')
   private Button zero;
   @FindBy(id = "com.android.calculator2:id/digit_1")
   @MyAnnotation(value = '1')
   private Button one;
   @FindBy(id = "com.android.calculator2:id/digit_2")
   @MyAnnotation(value = '2')
   private Button two;
   @FindBy(id = "com.android.calculator2:id/digit_3")
   @MyAnnotation(value = '3')
   private Button three;
   @FindBy(id = "com.android.calculator2:id/digit_4")
   @MyAnnotation(value = '4')
   private Button four;
   @FindBy(id = "com.android.calculator2:id/digit_5")
   @MyAnnotation(value = '5')
   private Button five;
   @FindBy(id = "com.android.calculator2:id/digit_6")
   @MyAnnotation(value = '6')
   private Button six;
   @FindBy(id = "com.android.calculator2:id/digit_7")
   @MyAnnotation(value = '7')
   private Button seven;
   @FindBy(id = "com.android.calculator2:id/digit_8")
   @MyAnnotation(value = '8')
   private Button eight;
   @FindBy(id = "com.android.calculator2:id/digit_9")
   @MyAnnotation(value = '9')
   private Button nine;
   @FindBy(id = "com.android.calculator2:id/op_add")
   @MyAnnotation(value = '+')
   private Button plus;
   @FindBy(id = "\tcom.android.calculator2:id/op_sub")
   @MyAnnotation(value = '-')
   private Button minus;
   @FindBy(id = "com.android.calculator2:id/eq")
   private Button equals;
   @FindBy(id = "com.android.calculator2:id/result")
   private WebElement result;
   @FindBy(id = "com.android.calculator2:id/dec_point")
   private Button dot;
   @FindBy(id = "com.android.calculator2:id/op_mul")
   @MyAnnotation(value = '*')
   private Button multiply;
   @FindBy(id = "com.android.calculator2:id/op_div")
   @MyAnnotation(value = '/')
   private Button division;

   public CalculatorPO() {
      super();
   }

   public void performClick(char number) {
      for (Field f : CalculatorPO.class.getDeclaredFields()) {
         MyAnnotation column = f.getAnnotation(MyAnnotation.class);
         if (column != null && column.value() == number) {
            try {
               f.setAccessible(true);
               CalculatorPO calculator = new CalculatorPO();
               Object objectValue = f.get(calculator);
               Method myMethod = objectValue.getClass().getDeclaredMethod("click");
               myMethod.invoke(objectValue);
            } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
               e.printStackTrace();
            }
         }
      }
   }

   public String getResult(){
      equals.click();
      return result.getText();
   }
}
