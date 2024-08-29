
package EduSys.entity;

import EduSys.utils.XDate;
import java.util.Date;

public class NguoiHoc {
    private String MaNH;
    private String HoTen;
    private Boolean GioiTinh = true ;
    private Date NgaySinh= XDate.addDate(new Date(), -365*20);
    private String DienThoai;
    private String Email;
    private String GhiChu;
    private String MaNV;
    private Date NgayDK = new Date();
    
    public NguoiHoc(String MaNH, String HoTen, Boolean GioiTinh, Date NgaySinh, String DienThoai, String Email, String GhiChu, String MaNV, Date NgayDK) {
        this.MaNH = MaNH;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DienThoai = DienThoai;
        this.Email = Email;
        this.GhiChu = GhiChu;
        this.MaNV = MaNV;
        this.NgayDK = NgayDK;
    }

    public NguoiHoc() {
    }

    public String getMaNH() {
        return MaNH;
    }

    public void setMaNH(String MaNH) {
        this.MaNH = MaNH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(Boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgayDK() {
        return NgayDK;
    }

    public void setNgayDK(Date NgayDK) {
        this.NgayDK = NgayDK;
    }

      
}
