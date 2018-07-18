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

   private Configuration() {
      prop = new Properties();
      loadConfigFile();
   }

   public static Configuration getInstance() {
      if (instance != null)
         return instance;
      else
         return instance = new Configuration();
   }

   private void loadConfigFile() {
      try (InputStream input = new FileInputStream("src/main/resources/calculator.properties")) {
         prop.load(input);
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }

   public Set<Object> getKeys() {
      return prop.keySet();
   }

   public Collection<Object> getValues() {
      return prop.values();
   }
}
