
package EduSys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class XDate {
    static SimpleDateFormat formater = new SimpleDateFormat();
    
    
    public static Date toDate(String date , String pattern ) throws ParseException{
            formater.applyPattern(pattern);
            return formater.parse(date);
    }
    
    
    public static String toString(Date date , String pattern){
        formater.applyPattern(pattern);
        return formater.format(date);
    }
    
    public static Date addDate(Date date , long day){
        date.setTime(date.getTime() + day*24*60*60*1000);
        return date;
    }
}
