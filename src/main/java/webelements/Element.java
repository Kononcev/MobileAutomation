package webelements;

import org.openqa.selenium.WebElement;

abstract class Element {
   WebElement webElement;

   Element(WebElement webElement) {
      this.webElement = webElement;
   }
}
