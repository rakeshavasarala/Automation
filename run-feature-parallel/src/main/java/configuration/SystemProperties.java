package configuration;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemProperties {
    public SystemProperties() {
    }

    public static Format formatter = new SimpleDateFormat("dd-M-yyyy hh:mm aaa");

    public static String getCurrentShortDate() {
        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat("hh:mm").format(new Date());
    }

    public static String getCurrentMeridian() {
        return new SimpleDateFormat("aaa").format(new Date());
    }

}