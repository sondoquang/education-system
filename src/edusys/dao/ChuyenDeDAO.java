
package EduSys.dao;

import EduSys.entity.ChuyenDe;


public interface ChuyenDeDAO extends EduSysDAO<ChuyenDe, String>{
    ChuyenDe SelectChuyenDeByMaKH(Integer makh);
    
}
