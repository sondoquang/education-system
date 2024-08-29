
package EduSys.controller;

import EduSys.Controller.Crudcontroller;
import EduSys.Controller.NaviController;
import EduSys.entity.KhoaHoc;

public interface KhoaHocController extends Crudcontroller,NaviController{
    KhoaHoc getForm();
    void setForm(KhoaHoc Entity);
    void fillToTableKhoaHoc();
    void fillToTableHocVien();
    void fillToTableNguoiHoc();
    void fillComboboxChuyenDe();
    void insertHocVien();
    void chonChuyenDe();
    void updateStatus();
    void selectAllNH();
    void clearSelectAllNH();
    void selectAllHV();
    void clearSelectAllHV();
    void updateDiem();
    void removeHocVien();
}
