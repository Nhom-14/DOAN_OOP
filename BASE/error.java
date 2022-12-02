package BASE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class error {

    public static int inputIntNumberError(String s) {
        try {
            int k = Integer.parseInt(s);
            return k;
        } catch (Exception e) {
            return -1;
        }
        
    }

    public static double inputDoubleNumberError(String s) {
        try {
            double k = Double.parseDouble(s);
            return k;
        } catch (Exception e) {
            return -1;
        }
        
    }

    public static long inputLongNumberError(String s) {
        try {
            long k = Long.parseLong(s);
            return k;
        } catch (Exception e) {
            return -1;
        }
    }

    public static char continueString(String s) {
        if(s.length() > 1) {
            return 'a';
        } else {
            try {
                char a = s.charAt(0);
                return a;
            } catch (Exception e) {
                return 'a';
            }
        }

    }

    public static Boolean checkKiTu(String s) {
        if (s == "") {
            return false;
        } else {
            Pattern rule= Pattern.compile("^[a-zA-Z0-9 ]*$");
            Matcher check = rule.matcher(s);
            if(check.matches()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static Boolean checkNgay(String s) {
        Pattern rule = Pattern.compile("\\d{2}[/]\\d{2}[/]\\d{4}");
        Matcher check = rule.matcher(s);
        if(check.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean checkSDT(String s) {
        Pattern rule = Pattern.compile("^0[3|5|7|8|9]\\d{8}$");
        Matcher check = rule.matcher(s);
        if(check.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean checkAddress(String s) {
        if (s == "") {
            return false;
        } else {
            Pattern rule= Pattern.compile("^[a-zA-Z0-9 /]*$");
            Matcher check = rule.matcher(s);
            if(check.matches()) {
                return true;
            } else {
                return false;
            }
        }
    }

}
// phieu yeu cau do an, bien ban cham, bam lai, ghi %.
