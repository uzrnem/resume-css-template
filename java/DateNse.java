import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

class DateNse {
  public static void main(String [] args) throws Exception {
    //2021-06-2
    Format formatter = new SimpleDateFormat("yyyy-MM-dd");
    String s = formatter.format(new Date());
    System.out.println(s);

    SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy");  
    try {  
        Date date = formatter2.parse("10-Jun-2022");  
        System.out.println("NSE Date is: " + date + "\nBroking Date: " + formatter.format(date));
    } catch (ParseException e) {e.printStackTrace();}  
  }
}