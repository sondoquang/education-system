
package EduSys.Controller;

import EduSys.entity.NhanVien;


public interface NhanVienContr extends Crudcontroller,NaviController {
    void setForm(NhanVien Entity);
    NhanVien getForm();
    void fillToTable();
    void updateStatus();
}
