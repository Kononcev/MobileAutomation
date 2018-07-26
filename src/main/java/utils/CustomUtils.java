package utils;


import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CustomUtils {
   public static void verifyExpression(String expression) throws Exception {
      Pattern pattern = Pattern.compile("(\\d+)([+*-/]\\d+)*([=\\d+])");
      Matcher matcher = pattern.matcher(expression);
      if (!matcher.matches() && !verifyExpressionIsCorrect(expression))
         throw new Exception();
   }

   private static boolean verifyExpressionIsCorrect(String expression){
      ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");

      String result = "";
      String expressionResult = "";
      try {
         result = engine.eval(StringUtils.substringBefore(expression,"=")).toString();
         expressionResult = StringUtils.substringAfter(expression,"=");
      }
      catch (ScriptException e) {
         e.printStackTrace();
      }
      return result.equals(expressionResult);
   }
}
