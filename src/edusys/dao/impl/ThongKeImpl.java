
package EduSys.dao.impl;

import EduSys.dao.ThongKeDAO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import EduSys.utils.Jdbc;

public class ThongKeImpl implements ThongKeDAO {

    @Override
    public List<Object[]> getListArray(String sql, String[] cols, Object... values) {
        try {
            List <Object[]> list = new ArrayList<>();
            ResultSet rs = Jdbc.executeQuery(sql, values);
            while(rs.next()){
                Object [] vals = new Object[cols.length];
                for(int i=0 ; i<cols.length ;i++){
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Object[]> getBangDiem(Integer makh) {
        String sql = "Exec sp_BangDiem ?";
        String [] cols = {"MaNH","HoTen","Diem"};
        return this.getListArray(sql,cols,makh);
    }

    @Override
    public List<Object[]> getLuongNguoiHoc() {
        String sql = "Exec sp_LuongNguoiHoc";
        String [] cols = {"Nam","SoLuong","DauTien","CuoiCung"};
        return this.getListArray(sql, cols);
    }

    @Override
    public List<Object[]> getChuyenDe() {
            String sql ="Exec sp_DiemChuyenDe";
        String [] cols = {"ChuyenDe","SoHV","ThapNhat","CaoNhat","TrungBinh"};
        return this.getListArray(sql, cols);
    }

    @Override
    public List<Object[]> getDoanhThu(Integer nam) {
        String sql = "Exec sp_DoanhThu ? ";
        String [] cols = {"ChuyenDe","SoKH","SoHV","DoanhThu","ThapNhat","CaoNhat","TrungBinh"};
        return this.getListArray(sql, cols,nam);
    }

    @Override
    public List<Integer> SelectYear() {
        String sql = "SELECT DISTINCT YEAR(NgayKG) FROM KHOAHOC ORDER BY YEAR(NgayKG) DESC";
        List<Integer> listNam = new ArrayList<>();
        try {
            ResultSet rs =  Jdbc.executeQuery(sql);
            while(rs.next()){
                listNam.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listNam;
    }
    
}
