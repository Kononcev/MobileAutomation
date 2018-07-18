package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webelements.CustomFieldDecorator;

public class PageObject {
   WebDriver driver;
   public PageObject() {
      this.driver=Driver.getInstance();
      PageFactory.initElements(new CustomFieldDecorator(driver), this);
   }

   public void dropDriver(){
      Driver.dropDriver();
   }
}
