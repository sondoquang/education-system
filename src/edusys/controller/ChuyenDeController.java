
package EduSys.Controller;

import EduSys.entity.ChuyenDe;

public interface ChuyenDeController extends NaviController,Crudcontroller{
    void setImage();
    void setForm(ChuyenDe Entity);
    ChuyenDe getForm();
    void fillToTable();
    void updateStatus();
}
