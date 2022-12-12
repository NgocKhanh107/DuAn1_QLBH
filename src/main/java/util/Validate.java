package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author hieu
 */
public class Validate {
    
    public static String checkMaNV = "^NV\\d\\d$";
    public static final String checkString = "[a-zA-Z]+";
    public static String checkSdt = "0\\d{9}";
    public static boolean chekcKhoangTrang(String text) {
        int temp = text.indexOf(" ");
        if (temp > -1) {
            return true;
        }
        return false;
    }

    public static boolean checkNullString(String text) {
        if (text.isBlank()) {
            return true;
        }
        return false;
    }

    public static boolean checkKyTuKhongDau(String text) { // check ký tự (Không bao gốm dấu)
        Pattern p = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher m = p.matcher(text);// Â
        return m.find();// Fasle
    }

    public static boolean checkKyTuCoDau(String text) { // check ký tự (Tviet có dấu)
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(text);// Â
        return m.find();// true
    }

    public static Boolean checkso(String text) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static Boolean checksoThuc(String text) {
        Pattern pattern = Pattern.compile("[0-9]{1,13}(\\.[0-9]*)?");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean checkNullText(JTextField txt) {
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(txt.getRootPane(), "Không được để trống ");
            return false;
        }
    }
}
