
package EduSys.Controller;

import EduSys.entity.NguoiHoc;

public interface NguoiHocController extends NaviController,Crudcontroller{
    void setForm(NguoiHoc Entity);
    NguoiHoc getForm();
    void fillToTable();
    void search();
    void updateStatus();
}
