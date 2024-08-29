
package EduSys.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

public class XMsgBox {
    public static void alert(Component component, String messenger){
        JOptionPane.showMessageDialog(null,messenger,"Hệ thống quản lý đào tạo" , JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void warning(Component component, String messager){
        JOptionPane.showMessageDialog(component, messager, "Hệ thống quản lý đào tạo", JOptionPane.WARNING_MESSAGE);
    }
    
    public static Boolean confirm(Component component,String messenger){
        int option = JOptionPane.showConfirmDialog(null, messenger, "Hệ thống quản lý đào tạo", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
        return option == JOptionPane.YES_OPTION;
    }
    
    public static String prompt(Component component,String messenge){
        return JOptionPane.showInputDialog(null, messenge, "Hệ thống quản lý đào tạo", JOptionPane.INFORMATION_MESSAGE);
    }
}   


