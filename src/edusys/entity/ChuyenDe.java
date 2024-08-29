
package EduSys.entity;



public class ChuyenDe {
    private String MaCD;
    private String TenCD;
    private Double HocPhi;
    private int ThoiLuong;
    private String Hinh;
    private String MoTa;

    public ChuyenDe(String MaCD, String TenCD, Double HocPhi, Integer ThoiLuong, String Hinh, String MoTa) {
        this.MaCD = MaCD;
        this.TenCD = TenCD;
        this.HocPhi = HocPhi;
        this.ThoiLuong = ThoiLuong;
        this.Hinh = Hinh;
        this.MoTa = MoTa;
    }

    public ChuyenDe() {
    }

    
    public String getMaCD() {
        return MaCD;
    }

    public void setMaCD(String MaCD) {
        this.MaCD = MaCD;
    }

    public String getTenCD() {
        return TenCD;
    }

    public void setTenCD(String TenCD) {
        this.TenCD = TenCD;
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

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    @Override
    public String toString() {
        return this.MaCD + " - " +this.TenCD;
    }


    @Override
    public boolean equals(Object obj) {
        ChuyenDe other = (ChuyenDe) obj;
        if(other == null)
            return false;
        return other.getMaCD().equals(this.getMaCD());
    }
    
    
    
    
}
