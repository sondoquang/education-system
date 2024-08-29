
package edusys.utils;

import EduSys.utils.XDate;
import java.text.ParseException;
import java.util.Date;

public class XCheck {
    public static Boolean checkMarkRegex(String diem){
        String regexDiem1 = "^[0-9]";
        String regexDiem2 = "^[0-9].[0-9]{0,}+";
        if(diem.matches(regexDiem1) == true || diem.matches(regexDiem2) == true){
            return true;
        }
        return false;
    }
    
    public static Boolean checkMark(Double mark){
        if(mark > 10 || mark < 0){
            return false;
        }else{
            return true;
        }
    }
    
    public static Boolean checkDate(String DateBefore, String DateAfter, String pattern){
        try {
            Date ngayTruoc = XDate.toDate(DateBefore, pattern);
            Date ngaySau = XDate.toDate(DateAfter, pattern);
            long TDate = ngayTruoc.getTime();
            long SDate = ngaySau.getTime();
            long HDate = SDate - TDate;
            long result = HDate/(24*60*60*1000);
            if(result <= 0){
                return false;
            }
        } catch (ParseException ex) {
            
        }
        return true;
    }
}
