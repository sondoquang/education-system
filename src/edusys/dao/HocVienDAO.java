
package EduSys.dao;

import EduSys.entity.HocVien;
import java.util.List;

public interface HocVienDAO extends EduSysDAO<HocVien, Integer>{
    List<HocVien> SelectByKhoaHoc(Integer makh);
}
