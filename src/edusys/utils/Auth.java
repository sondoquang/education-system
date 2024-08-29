
package EduSys.utils;

import EduSys.entity.NhanVien;



public class Auth {
    // Thông tin người đang đăng nhập vào hệ thống  //
    public static NhanVien user = null;
    public static void clear(){
        Auth.user = null;
    }
    public static boolean isLogin(){
        return Auth.user != null;
    }
    public static boolean isManager(){
        return Auth.isLogin() && Auth.user.isVaiTro();
    }
}
