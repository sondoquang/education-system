package EduSys.dao;


import EduSys.entity.NguoiHoc;
import java.util.List;

public interface NguoiHocDAO extends EduSysDAO<NguoiHoc, String>{
     List <NguoiHoc> SelectByKeyWord(String keyword);
     List <NguoiHoc> SelectNotStudents(Integer makh);
     List <NguoiHoc> SelectNotInCourseID(Integer makh,String keyword);
     
}
