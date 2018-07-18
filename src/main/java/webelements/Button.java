package webelements;

import org.openqa.selenium.WebElement;

public class Button {
   private WebElement webElement;

   public Button() {
   }

   protected Button(WebElement webElement) {
      this.webElement = webElement;
   }

   public boolean isEnabled() {
      return webElement.isEnabled();
   }

   public void click() {
      webElement.click();
   }
}
