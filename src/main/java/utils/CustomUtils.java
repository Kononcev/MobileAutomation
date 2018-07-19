package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomUtils {
   public static void verifyExpression(String expression) throws Exception {
      Pattern pattern = Pattern.compile("(\\d+)([+*-/]\\d+)*");
      Matcher matcher = pattern.matcher(expression);
      if (!matcher.matches())
         throw new Exception();
   }
}
