package model;

import driver.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webelements.Button;

import java.lang.reflect.Field;

public class Calculator extends PageObject {
   @FindBy(id = "com.android.calculator2:id/digit_0")
   @MyAnnotation(value = 0)
   private Button zero;
   @FindBy(id = "com.android.calculator2:id/digit_1")
   @MyAnnotation(value = 1)
   private Button one;
   @FindBy(id = "com.android.calculator2:id/digit_2")
   @MyAnnotation(value = 2)
   private Button two;
   @FindBy(id = "com.android.calculator2:id/digit_3")
   @MyAnnotation(value = 3)
   private Button three;
   @FindBy(id = "com.android.calculator2:id/digit_4")
   @MyAnnotation(value = 4)
   private Button four;
   @FindBy(id = "com.android.calculator2:id/digit_5")
   @MyAnnotation(value = 5)
   private Button five;
   @FindBy(id = "com.android.calculator2:id/digit_6")
   @MyAnnotation(value = 6)
   private Button six;
   @FindBy(id = "com.android.calculator2:id/digit_7")
   @MyAnnotation(value = 7)
   private Button seven;
   @FindBy(id = "com.android.calculator2:id/digit_8")
   @MyAnnotation(value = 8)
   private Button eight;
   @FindBy(id = "com.android.calculator2:id/digit_9")
   @MyAnnotation(value = 9)
   private Button nine;
   @FindBy(id = "com.android.calculator2:id/op_add")
   private Button plus;
   @FindBy(id = "\tcom.android.calculator2:id/op_sub")
   private Button minus;
   @FindBy(id = "com.android.calculator2:id/eq")
   private Button equals;
   @FindBy(id = "com.android.calculator2:id/result")
   private WebElement result;
   @FindBy(id = "com.android.calculator2:id/dec_point")
   private Button dot;
   @FindBy(id = "com.android.calculator2:id/op_mul")
   private Button multiply;
   @FindBy(id = "com.android.calculator2:id/op_div")
   private Button division;

   public double plus(WebElement first, WebElement second) {

      first.click();
      plus.click();
      second.click();
      equals.click();
      return Double.valueOf(result.getText());
   }

   public double minus(WebElement first, WebElement second) {
      first.click();
      minus.click();
      second.click();
      equals.click();
      return Double.valueOf(result.getText());
   }

   public double multiply(WebElement first, WebElement second) {
      first.click();
      multiply.click();
      second.click();
      equals.click();
      return Double.valueOf(result.getText());
   }

   public static WebElement getField(int number) {
      for (Field f : Calculator.class.getDeclaredFields()) {
         MyAnnotation column = f.getAnnotation(MyAnnotation.class);
         if (column != null && column.value() == number) {
            Class<?> targetType = f.getType();
            try {
               Object objectValue = targetType.newInstance();
               Object value = f.get(objectValue);
               return (WebElement) value;
            } catch (InstantiationException e) {
               e.printStackTrace();
            } catch (IllegalAccessException e) {
               e.printStackTrace();
            }
         }
      }
      return null;
   }

   public static void main(String[] args) {
      WebElement webElement = getField(1);
      webElement.click();
   }

   public double divide(WebElement first, WebElement second) {
      first.click();
      division.click();
      second.click();
      equals.click();
      return Double.valueOf(result.getText());
   }
}
