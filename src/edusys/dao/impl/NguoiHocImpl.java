
package EduSys.dao.impl;

import EduSys.dao.NguoiHocDAO;
import EduSys.entity.NguoiHoc;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import EduSys.utils.Jdbc;


public class NguoiHocImpl implements NguoiHocDAO{

    @Override
    public List<NguoiHoc> selectBySQl(String sql, Object...values) {
        List <NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = Jdbc.executeQuery(sql, values);
                while(rs.next()){
                    NguoiHoc nh = new NguoiHoc();
                    nh.setMaNH(rs.getString(1));
                    nh.setHoTen(rs.getString(2));
                    nh.setNgaySinh(rs.getDate(3));
                    nh.setGioiTinh(rs.getBoolean(4));
                    nh.setDienThoai(rs.getString(5));
                    nh.setEmail(rs.getString(6));
                    nh.setGhiChu(rs.getString(7));
                    nh.setMaNV(rs.getString(8));
                    nh.setNgayDK(rs.getDate(9));
                    list.add(nh);
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<NguoiHoc> selectAll() {
        String sql = "Select * from NguoiHoc";
        List <NguoiHoc> list = selectBySQl(sql);
        return list;
    }

    @Override
    public NguoiHoc selectByID(String ID) { 
        String sql = "Select * from NguoiHoc where MaNH = ?";
        List<NguoiHoc> list = selectBySQl(sql ,ID);
        return list.size() > 0?list.get(0 ):null;
    }


    @Override
    public void delete(String ID) {
        String sql = "Delete from NguoiHoc where MaNH = ? ";
        Jdbc.executeUpdate(sql, ID);
    }

    @Override
    public List<NguoiHoc> SelectByKeyWord(String keyword) {
        String sql = "Select * from NguoiHoc where HoTen like ?";
        return this.selectBySQl(sql,"%"+keyword+"%");
    }

    @Override
    public List<NguoiHoc> SelectNotStudents(Integer makh) {
        String sql ="select * from NguoiHoc where makh = ? ";
        return this.selectBySQl(sql,makh);
    }

    @Override
    public List<NguoiHoc> SelectNotInCourseID(Integer makh,String keyword) {
        String sql = "SELECT * FROM NGUOIHOC WHERE HOTEN LIKE ? AND MANH NOT IN (SELECT MANH FROM HOCVIEN WHERE MAKH = ?)";
        Object [] values = {"%"+keyword+"%",makh};
        return this.selectBySQl(sql, values);
    }

    @Override
    public NguoiHoc update(NguoiHoc Entity) {
        String sql ="Update NguoiHoc set "
                + "HoTen = ?, GioiTinh = ? ,NgaySinh =? , "
                + "DienThoai = ?, Email = ?, GhiChu = ? ,"
                + "MaNV = ? , NgayDK = ? where MaNH = ? ";
        Object [] values = {
            Entity.getHoTen(),
            Entity.getGioiTinh(),
            Entity.getNgaySinh(),
            Entity.getDienThoai(),
            Entity.getEmail(),
            Entity.getGhiChu(),
            Entity.getMaNV(),
            Entity.getNgayDK(),
            Entity.getMaNH()
        };
        Jdbc.executeUpdate(sql,values);
        return Entity;
    }

    @Override
    public NguoiHoc insert(NguoiHoc Entity) {
        String sql ="INSERT INTO NguoiHoc (MaNH, HoTen ,GioiTinh ,NgaySinh ,DienThoai ,Email ,GhiChu ,MaNV ,NgayDK) VALUES (?, ?, ?, ? , ?, ? , ?, ? ,?)";
        Object [] values = {
            Entity.getMaNH(),
            Entity.getHoTen(),
            Entity.getGioiTinh(),
            Entity.getNgaySinh(),
            Entity.getDienThoai(),
            Entity.getEmail(),
            Entity.getGhiChu(),
            Entity.getMaNV(),
            Entity.getNgayDK(),
        };
        Jdbc.executeUpdate(sql,values);
        return Entity;
    }    
}
