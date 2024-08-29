
package edusys.controller;

public interface ThongKeController {
    void innitialize();
    void setSelectTab(int index);
    void fillTableBangDiem();
    void fillTableNguoiHoc();
    void fillTableDiemChuyenDe();
    void fillTableDoanhThu();
    void fillComboBoxNam();
    void fillComboBoxKhoaHoc();
    String getXepLoai(Double mark);
    
}
