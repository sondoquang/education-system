
package EduSys.entity;


public class HocVien {
    private Integer MaHV;
    private Integer MaKH;
    private String MaNH;
    private Double Diem;

    public HocVien() {
    }

    public Integer getMaHV() {
        return MaHV;
    }

    public void setMaHV(Integer MaHV) {
        this.MaHV = MaHV;
    }

    public Integer getMaKH() {
        return MaKH;
    }

    public void setMaKH(Integer MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNH() {
        return MaNH;
    }

    public void setMaNH(String MaNH) {
        this.MaNH = MaNH;
    }

    public Double getDiem() {
        return Diem;
    }

    public void setDiem(Double Diem) {
        this.Diem = Diem;
    }
    
}
