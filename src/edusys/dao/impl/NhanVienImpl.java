
package EduSys.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;
import EduSys.dao.NhanVienDAO;
import EduSys.entity.NhanVien;
import EduSys.utils.Jdbc;

public class NhanVienImpl implements NhanVienDAO{

    @Override
    public NhanVien update(NhanVien entity) {
        String sql = "Update NhanVien set MatKhau = ?, HoTen = ?, VaiTro = ? where MaNV = ?";
        Object []args= {
            entity.getMatKhau(),
            entity.getHoTen(),
            entity.isVaiTro(),
            entity.getMaNV()
        };
        Jdbc.executeUpdate(sql, args);
        return entity;
    }


    @Override
    public List<NhanVien> selectBySQl(String sql, Object... values) {
        List <NhanVien> list = new ArrayList<>();
        try{
            ResultSet rs = Jdbc.executeQuery(sql, values);
            while(rs.next()){
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString(1));
                entity.setMatKhau(rs.getString(2));
                entity.setHoTen(rs.getString(3));
                entity.setVaiTro(rs.getBoolean(4));
                list.add(entity);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<NhanVien> selectAll() {
        String sql = "Select * from nhanvien";
        List <NhanVien> list = this.selectBySQl(sql);
        return list;
    }

    @Override
    public NhanVien selectByID(String ID) {
        String Sql = "Select * from NhanVien where manv = ?";
        List<NhanVien> list = this.selectBySQl(Sql, ID);
        return !list.isEmpty()?list.get(0):null;
    }

    @Override
    public NhanVien insert(NhanVien entity) {
        String sql = "insert into NhanVien (MaNV, MatKhau, HoTen, VaiTro) values (?, ?, ?, ?)";
        Object [] args = {
            entity.getMaNV(),
            entity.getMatKhau(),
            entity.getHoTen(),
            entity.isVaiTro(),
        };
        Jdbc.executeUpdate(sql, args);
        return entity;
    }

    @Override
    public void delete(String ID) {
        String sql = "delete from NhanVien where MaNV = ?";
        Jdbc.executeUpdate(sql, ID);
    }
    
}
