package random;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTest {
    public static void main(String[] args) {
//        Date d = new Date();
//        System.out.println(d.getTime());
//        DateFormat df = DateFormat.getInstance();
//        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL);
//        System.out.println(df.format(d));
//        System.out.println(df2.format(d));

//        Locale locIT = new Locale("it");    // Italian - Italy
//        Locale locCH = new Locale("it", "CH");  //italian - Switzerland

        Calendar c = Calendar.getInstance();
        c.set(2020,8,24);

        Date d2 = c.getTime();

        Locale locIT = new Locale("it", "IT");  // Italian - Italy
        Locale locPT = new Locale("pt");    //Portugese
        Locale locBR = new Locale("pt", "BR");  //Portugese - Brazil
        Locale locIN = new Locale("hi", "In");  //Hindi - India

        DateFormat dfUS = DateFormat.getInstance();
        System.out.println("US      " + dfUS.format(d2));

        DateFormat dfUSfull = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("US full      " + dfUSfull.format(d2));

        DateFormat dfIT = DateFormat.getDateInstance(DateFormat.FULL, locIT);
        System.out.println("Italy      " + dfIT.format(d2));

        DateFormat dfPT = DateFormat.getDateInstance(DateFormat.FULL, locPT);
        System.out.println("Portugal      " + dfPT.format(d2));

        DateFormat dfBR = DateFormat.getDateInstance(DateFormat.FULL, locBR);
        System.out.println("Brazil      " + dfBR.format(d2));

        DateFormat dfIN = DateFormat.getDateInstance(DateFormat.FULL, locIN);
        System.out.println("India      " + dfIN.format(d2));
    }
}

