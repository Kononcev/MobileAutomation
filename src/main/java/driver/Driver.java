package driver;


import configuration.Configuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Driver {
   private static URL url;
   private static ThreadLocal<AppiumDriver> webDriverThreadLocal = new ThreadLocal<>();

   static {
      Configuration.getInstance();
      try {
         url = new URL("http://127.0.0.1:4723/wd/hub");
      } catch (MalformedURLException e) {
         e.printStackTrace();
      }
   }

   private Driver() {
   }

   private static DesiredCapabilities setCapabilities() {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      for(Map.Entry<Object, Object> properties: Configuration.getProp().entrySet()){
         capabilities.setCapability(properties.getKey().toString(), properties.getValue());
      }
      return capabilities;
   }

   public static AppiumDriver getInstance() {
      if (webDriverThreadLocal.get() != null) {
         return webDriverThreadLocal.get();
      }
      webDriverThreadLocal.set(new AndroidDriver(url, setCapabilities()));
      webDriverThreadLocal.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

      return webDriverThreadLocal.get();
   }

   public static void dropDriver() {
      try {
         webDriverThreadLocal.get().quit();
      } finally {
         webDriverThreadLocal.remove();
      }
   }

   public static void closeApp(){
      webDriverThreadLocal.get().switchTo().alert().dismiss();
   }

}
