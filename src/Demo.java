import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    /**
     * Check "AppInitializer"
     */


    //================================================01 ) Pattern.matches
    /*public static void main(String[] args) {
        String text = "kasunmiuranga2000@gmail.com";
        String pattern = ".*([a-z 0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,}).*";

        boolean isMatches = Pattern.matches(pattern, text);
        System.out.println(isMatches);
    }*/

    //================================================02 ) Pattern.compile
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^([a-z 0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})$");
        Matcher matcher = pattern.matcher("kasunmiuranga2000@gmail.com");

        boolean isMatches = matcher.matches();
        if (isMatches){
            System.out.println("matching");
        }else {
            System.err.println("Not matching");

        }
    }
    //================================================
   /* public static void main(String[] args) {
        Pattern pattern = Pattern.compile("([a-z 0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})");
        Matcher matcher = pattern.matcher("kasunmiuranga2000@gmail.com");

        while (matcher.find()){
            System.err.println("Index start : "+matcher.start() +" - "+"Index start : "+ matcher.end());
        }
        boolean isMatches = matcher.matches();
        System.out.println(isMatches);
    }*/
}