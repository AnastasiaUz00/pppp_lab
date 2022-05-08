/**
 * Created by Maxim on 09.05.2022.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
        public Main() {
            super();
        }
        public static String formateToPhoneNumber(String number, String format,int maxLength) {
            String onlyDidgits = number.replaceAll("\\D+","");
            if(onlyDidgits.length()>maxLength){

                onlyDidgits=onlyDidgits.substring(0,maxLength);
            }
            char[] arr = new char[format.length()];
            int i = 0;
            for (int j = 0; j < format.length(); j++) {
                if(i>=onlyDidgits.length())
                    break;
                if (format.charAt(j) == 'X')
                    arr[j] = onlyDidgits.charAt(i++);
                else
                    arr[j] = format.charAt(j);
            }
            String formatedNo=  new String(arr);
            Pattern p = Pattern.compile("[0-9]");
            Matcher m = p.matcher(""+(formatedNo.charAt(formatedNo.length()-1)));
            if(!m.matches()){
                formatedNo= new StringBuilder(formatedNo).deleteCharAt(formatedNo.length()-1).toString();
            }
            return formatedNo;
        }
        public static void main(String[] args) throws Exception {

            try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Maxim\\IdeaProjects\\pppp_lab\\src\\text.txt ")))
            {
                String s;
                while((s=br.readLine())!=null){

                    System.out.println(Main.formateToPhoneNumber(s,"Звоните по номеру +1(900)XXXXXXX",10));
                }
            }
        }
}
