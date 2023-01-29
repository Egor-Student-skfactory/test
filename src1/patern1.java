import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patern1 {
    public static void main(String[] args){

        String text =
            "WrongMsisdnError SuccessfulTransaction TimeOutError InternalError SuccessfulTransaction ExternalIDError SuccessfulTransaction WrongIDError" +
                    "InvalidArgumentError Successfultransaction SuccessfulTransaction SuccessfulTransaction WrongMsisdnError";
        String [] str =text.split(" ");
      for (String s:str){
          if (Pattern.matches(".*?Error",s)){
              System.out.println(s +" ");
          }
        }
    }
}
// Pattern pattern = Pattern.compile("");
// Matcher matcher = pattern.matcher(text);
//System.out.println(matcher.group());