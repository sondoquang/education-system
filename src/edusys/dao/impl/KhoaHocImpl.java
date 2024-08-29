
package EduSys.dao.impl;

import EduSys.dao.KhoaHocDAO;
import EduSys.entity.KhoaHoc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import EduSys.utils.Jdbc;


public class KhoaHocImpl implements KhoaHocDAO{

    @Override
    public List<KhoaHoc> selectBySQl(String sql, Object... agrs) {
        List <KhoaHoc> list = new ArrayList<>();
        try {
            ResultSet rs = Jdbc.executeQuery(sql, agrs);
            while(rs.next()){
                KhoaHoc kh = new KhoaHoc();
                kh.setMaKH(rs.getInt(1));
                kh.setMaCD(rs.getString(2));
                kh.setHocPhi(rs.getDouble(3));
                kh.setThoiLuong(rs.getInt(4));
                kh.setNgayKG(rs.getDate(5));
                kh.setGhiChu(rs.getString(6));
                kh.setMaNV(rs.getString(7));
                kh.setNgayTao(rs.getDate(8));
                list.add(kh);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<KhoaHoc> selectAll() {
        String Sql = "SELECT * FROM KHOAHOC ";
        List <KhoaHoc> list = selectBySQl(Sql);
        return list;
    }

    @Override
    public KhoaHoc selectByID(Integer ID) {
        String sql = "SELECT * FROM KHOAHOC WHERE MAKH = ?";
        List <KhoaHoc> list = selectBySQl(sql,ID);
        return list.size() > 0? list.get(0):null;
    }


    @Override
    public void delete(Integer ID) {
        String sql ="Delete from KhoaHoc where MaKH = ?";
        Jdbc.executeUpdate(sql,ID);
    }

    @Override
    public KhoaHoc update(KhoaHoc Entity) {
        String sql = "UPDATE KhoaHoc SET MaCD = ?,HocPhi = ?,ThoiLuong = ?, NgayKG = ? ,GhiChu = ?, MaNV = ? , NgayTao = ? WHERE MaKH = ? ";
        Object [] values = {
            Entity.getMaCD(),
            Entity.getHocPhi(),
            Entity.getThoiLuong(),
            Entity.getNgayKG(),
            Entity.getGhiChu(),
            Entity.getMaNV(),
            Entity.getNgayTao(),
            Entity.getMaKH()
        };
        Jdbc.executeUpdate(sql, values);
        return Entity;
    }

    @Override
    public KhoaHoc insert(KhoaHoc Entity) {
        String sql = "INSERT INTO KhoaHoc (MaCD,HocPhi,ThoiLuong,ngayKG,GhiChu,MaNV,NgayTao) VALUES (?, ?, ? , ?, ? , ?, ?)";
        Object [] values = {
            Entity.getMaCD(),
            Entity.getHocPhi(),
            Entity.getThoiLuong(),
            Entity.getNgayKG(),
            Entity.getGhiChu(),
            Entity.getMaNV(),
            Entity.getNgayTao()
        };
        Jdbc.executeUpdate(sql, values);
        return Entity;
    }

    @Override
    public List<KhoaHoc> selectKhoaHocByMaChuyenDe(String macd) {
        String sql ="Select * from KhoaHoc where MaCD = ? ";
        return this.selectBySQl(sql, macd);
    }
}
