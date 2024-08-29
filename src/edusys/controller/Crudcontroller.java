
package EduSys.Controller;

public interface Crudcontroller {
    // Window opened //
    void initialize();
    // Chèn dữ liệu từ form vào database //
    void insert();
    //Update dữ liệu vào database //
    void update();
    // Xóa ... trong database
    void delete();
    // Đưa dữ liệu lên form //
    void edit();
//    Xóa dữ liệu của form //
    void clearForm();
}
