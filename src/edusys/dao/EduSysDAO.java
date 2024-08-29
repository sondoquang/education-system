
package EduSys.dao;
import java.util.List;

public interface EduSysDAO <T,PK> {
    List <T>  selectBySQl(String sql ,Object...agrs);
    List <T> selectAll();
    T selectByID(PK ID);
    T update(T Entity);
    T insert(T Entity);
    void delete(PK ID);
   
}
