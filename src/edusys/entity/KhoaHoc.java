
package EduSys.entity;

import EduSys.utils.Auth;
import EduSys.utils.XDate;
import java.util.Date;

public class KhoaHoc{
    private Integer MaKH;
    private String MaCD ;
    private Double HocPhi;
    private Integer ThoiLuong;
    private Date NgayKG = XDate.addDate(new Date(),7 );
    private String GhiChu;
    private String MaNV = Auth.user.getMaNV();
    private Date NgayTao = new Date();

    public KhoaHoc(Integer MaKH, String MaCD, Double HocPhi, Integer ThoiLuong, Date NgayKG, String GhiChu, String MaNV, Date NgayTao) {
        this.MaKH = MaKH;
        this.MaCD = MaCD;
        this.HocPhi = HocPhi;
        this.ThoiLuong = ThoiLuong;
        this.NgayKG = NgayKG;
        this.GhiChu = GhiChu;
        this.MaNV = MaNV;
        this.NgayTao = NgayTao;
    }

    public KhoaHoc() {
    }
    
    public Integer getMaKH() {
        return MaKH;
    }

    public void setMaKH(Integer MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaCD() {
        return MaCD;
    }

    public void setMaCD(String MaCD) {
        this.MaCD = MaCD;
    }

    public Double getHocPhi() {
        return HocPhi;
    }

    public void setHocPhi(Double HocPhi) {
        this.HocPhi = HocPhi;
    }

    public Integer getThoiLuong() {
        return ThoiLuong;
    }

    public void setThoiLuong(Integer ThoiLuong) {
        this.ThoiLuong = ThoiLuong;
    }

    public Date getNgayKG() {
        return NgayKG;
    }

    public void setNgayKG(Date NgayKG) {
        this.NgayKG = NgayKG;
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

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    @Override
    public String toString() {
        return this.MaCD + " ( " + this.NgayTao +" )";
    }


    @Override
    public boolean equals(Object obj) {
        KhoaHoc other = (KhoaHoc) obj;
        if(other == null){
            return false;
        }
        return other.getMaKH().equals(this.getMaKH());
    }
}
