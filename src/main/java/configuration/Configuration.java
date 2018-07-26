package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class Configuration {
   private static Properties prop;
   private static Configuration instance;
   private static String path;

   private Configuration() {
      prop = new Properties();
      loadConfigFile();
   }

   static {
      loadMainConfigFile();
      String testType = System.getProperty("testType");
      if(testType.equals("webView"))
         path = "src/main/resources/google.properties";
      else if(testType.equals("native"))
         path = "src/main/resources/calculator.properties";

   }

   public static Configuration getInstance() {
      if (instance != null)
         return instance;
      else
         return instance = new Configuration();
   }

   private void loadConfigFile() {
      try (InputStream input = new FileInputStream(path)) {
         prop.load(input);
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }

   private static void loadMainConfigFile() {
      try (InputStream input = new FileInputStream("src/main/resources/configuration.properties")) {
         System.getProperties().load(input);
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }

   public static Properties getProp(){
      return prop;
   }

   public static String getProperty(String key){
      return prop.getProperty(key);
   }
}
