package driver;


import org.openqa.selenium.support.PageFactory;
import webelements.CustomFieldDecorator;

public class PageObject {
   public PageObject() {
      PageFactory.initElements(new CustomFieldDecorator(Driver.getInstance()), this);
   }
}
