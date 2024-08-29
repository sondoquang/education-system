package EduSys.dao.impl;

import EduSys.dao.HocVienDAO;
import EduSys.entity.HocVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import EduSys.utils.Jdbc;

public class HocVienImpl implements HocVienDAO{

    @Override
    public List<HocVien> selectBySQl(String sql, Object... agrs) {
        List <HocVien> list = new ArrayList<>();
        try{
            ResultSet rs = Jdbc.executeQuery(sql, agrs);
            while(rs.next()){
                HocVien hv = new HocVien();
                hv.setMaHV(rs.getInt(1));
                hv.setMaKH(rs.getInt(2));
                hv.setMaNH(rs.getString(3));
                hv.setDiem(rs.getDouble(4));
                list.add(hv);
            }
        }catch(Exception e){
            return null;
        }
        return list;
    }
    
    @Override
    public List<HocVien> selectAll() {
        String sql ="select * from HocVien";
        List <HocVien> list = selectBySQl(sql);
        return list;
    }

    @Override
    public HocVien selectByID(Integer ID) {
        String sql = "Select * from HocVien where MaHV = ?";
        List <HocVien> list = selectBySQl(sql, ID);
        return list.size() > 0 ? list.get(0):null;
    }

    @Override
    public HocVien update(HocVien Entity) {
        String sql = "Update HocVien set Diem = ? where MaHV = ?";
        Object values [] ={
            Entity.getDiem(),
            Entity.getMaHV()
        };
        Jdbc.executeUpdate(sql, values);
        return Entity;
    }

    @Override
    public HocVien insert(HocVien Entity) {
        String sql = "Insert into HocVien (MaKH , MaNH ,Diem) values (? ,? ,?)";
        Object values [] ={
            Entity.getMaKH(),
            Entity.getMaNH(),
            Entity.getDiem()
        };
        Jdbc.executeUpdate(sql, values);
        return Entity;
    }

    @Override
    public void delete(Integer ID) {
        String sql = "Delete from HocVien where MaHV = ?";
        Jdbc.executeUpdate(sql, ID);
    }

    @Override
    public List<HocVien> SelectByKhoaHoc(Integer makh) {
        String sql ="Select * from hocvien where makh = ? ";
        return this.selectBySQl(sql, makh);
    }
    
}
