package idstay;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by min on 5/6/17.
 */
public class UtilTest {

    public static Date toDate(String dateString, String pattern) {
        SimpleDateFormat transFormat = new SimpleDateFormat(pattern);

        Date to = null;
        try {
            to = transFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return to;
    }

    @Test
    public void toDate() {
        String from = "2013-04-08";
        System.out.println(toDate(from, "YYYY-MM-DD"));

        from = "Jan 02 2017";
        System.out.println(toDate(from, "MMM DD YYYY"));

        from = "27-Nov-2016";
        System.out.println(toDate(from, "DD-MMM-YYYY"));

        from = "2016-12-09";
        System.out.println(toDate(from, "YYYY-MM-DD"));
    }

    @Test
    public void match() {
        String from = "2013-04-08";


    }

    private boolean matched(String regex, String inputTxt) {
        return Pattern.matches(regex, inputTxt);
    }
}
