
package EduSys.dao;

import EduSys.entity.KhoaHoc;
import java.util.List;
public interface KhoaHocDAO extends  EduSysDAO<KhoaHoc, Integer> {
    List <KhoaHoc> selectKhoaHocByMaChuyenDe(String macd);
}
