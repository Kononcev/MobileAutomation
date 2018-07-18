package driver;


import configuration.Configuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Driver {
   private static URL url;
   private static ThreadLocal<AppiumDriver> webDriverThreadLocal = new ThreadLocal<>();
   private static Configuration configuration;

   static {
      configuration = Configuration.getInstance();
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
      IntStream.range(0, configuration.getKeys().size()).forEach(index->{
         capabilities.setCapability(configuration.getKeys().toArray()[index].toString(), configuration.getValues().toArray()[index]);
      });
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

}
