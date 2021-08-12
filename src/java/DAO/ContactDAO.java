package DAO;

import Model.ContactModel;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author NguyenManhCuong
 */
public class ContactDAO {

    // Khai báo các thành phần xử lý DB
    Connection cnn;// Kết nối CSDL
    PreparedStatement ps; // Thực hiện câu lệnh SQL
    ResultSet rs; // Lưu trữ và xử lý dư liệu
    DBContext db = new DBContext();

    public ContactModel findContactModel() throws Exception {
        try {
            String sqlQuery = "SELECT * FROM dbo.Contact";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            rs = ps.executeQuery();
            ContactModel contactModel = new ContactModel();
            while (rs.next()) {
                contactModel.setAddress(rs.getString("address"));
                contactModel.setCity(rs.getString("city"));
                contactModel.setCountry(rs.getString("country"));
                contactModel.setTelephone(rs.getString("telephone"));
                contactModel.setEmail(rs.getString("email"));
                contactModel.setFaceUrl(rs.getString("face_url"));
                contactModel.setTwitterUrl(rs.getString("twitter_url"));
                contactModel.setGoogleUrl(rs.getString("google_url"));
                contactModel.setAbout(rs.getString("about"));
                contactModel.setImageMain(rs.getString("image_main"));
                contactModel.setMap(rs.getString("map"));
                contactModel.setContentMain(rs.getString("content_main"));
            }
            return contactModel;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
    }
}
