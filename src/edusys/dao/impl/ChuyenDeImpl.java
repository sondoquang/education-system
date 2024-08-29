package EduSys.dao.impl;

import EduSys.dao.ChuyenDeDAO;
import EduSys.entity.ChuyenDe;
import EduSys.utils.Jdbc;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChuyenDeImpl implements ChuyenDeDAO {

    @Override
    public List<ChuyenDe> selectBySQl(String sql, Object... values) {
        List<ChuyenDe> list = new ArrayList<>();
        try {
            ResultSet rs = Jdbc.executeQuery(sql, values);
            while (rs.next()) {
                ChuyenDe cd = new ChuyenDe();
                cd.setMaCD(rs.getString(1));
                cd.setTenCD(rs.getString(2));
                cd.setThoiLuong(rs.getInt(4));
                cd.setHocPhi(rs.getDouble(3));
                cd.setMoTa(rs.getString(6));
                cd.setHinh(rs.getString(5));
                list.add(cd);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return list;
    }

    @Override
    public List<ChuyenDe> selectAll() {
        String sql = "Select * from ChuyenDe";
        List<ChuyenDe> list = this.selectBySQl(sql);
        return list;
    }

    @Override
    public ChuyenDe selectByID(String id) {
        String sql = "Select * from ChuyenDe where MaCD = ? ";
        List<ChuyenDe> list = this.selectBySQl(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public ChuyenDe update(ChuyenDe Entity) {
        String sql = "UPDATE CHUYENDE SET TENCD = ?, THOILUONG = ?, HOCPHI = ? , HINH = ?, MOTA = ? WHERE MaCD = ? ";
        Object[] values = {
            Entity.getTenCD(),
            Entity.getThoiLuong(),
            Entity.getHocPhi(),
            Entity.getHinh(),
            Entity.getMoTa(),
            Entity.getMaCD()
        };
        Jdbc.executeUpdate(sql, values);
        return Entity;
    }

    @Override
    public ChuyenDe insert(ChuyenDe Entity) {
        String sql = " INSERT INTO CHUYENDE (MaCD, tencd,  ThoiLuong, Hocphi, hinh, mota) VALUES (?, ?, ?, ?,?,?)";
        Object[] values = {
            Entity.getMaCD(),
            Entity.getTenCD(),
            Entity.getThoiLuong(),
            Entity.getHocPhi(),
            Entity.getHinh(),
            Entity.getMoTa()
        };
        Jdbc.executeUpdate(sql, values);
        return Entity;
    }

    @Override
    public void delete(String ID) {
        String sql = "Delete from ChuyenDe where MaCD = ?";
        Jdbc.executeUpdate(sql, ID);
    }

    @Override
    public ChuyenDe SelectChuyenDeByMaKH(Integer makh) {
        String sql = "Select cd.* from ChuyenDe cd inner join KhoaHoc kh on kh.macd = cd.macd where makh = ? ";
        List<ChuyenDe> list = this.selectBySQl(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }
}
