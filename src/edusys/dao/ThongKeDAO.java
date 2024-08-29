
package EduSys.dao;

import java.util.List;

public interface ThongKeDAO {
    List<Object[]> getListArray(String sql ,String [] cols ,Object...values);
    List<Object[]> getBangDiem(Integer makh);
    List<Object[]> getLuongNguoiHoc();
    List<Object[]> getChuyenDe();
    List<Object[]> getDoanhThu(Integer nam);
    List<Integer> SelectYear();
}
