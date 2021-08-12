package DAO;

import Model.GalleryModel;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import paging.PageRequest;

/**
 *
 * @author NguyenManhCuong
 */
public class GalleryDAO {

    // Khai báo các thành phần xử lý DB
    Connection cnn;// Kết nối CSDL
    PreparedStatement ps; // Thực hiện câu lệnh SQL
    ResultSet rs; // Lưu trữ và xử lý dư liệu
    DBContext db = new DBContext();

    public int countAllGallery() throws Exception {
        try {
            String sqlQuery = "Select COUNT(*) from Gallery";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
    }

    public ArrayList<GalleryModel> getlistGallery(PageRequest page) throws Exception {
        try {
            String sqlQuery = "Select * from Gallery order by id offset ? rows fetch next ? rows only";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            ps.setInt(1, page.getOffset());
            ps.setInt(2, page.getLimit());
            rs = ps.executeQuery();
            ArrayList<GalleryModel> listGallery = new ArrayList<GalleryModel>();
            while (rs.next()) {
                GalleryModel galleryModel = new GalleryModel();
                galleryModel.setId(rs.getInt("id"));
                galleryModel.setTitle(rs.getString("title"));
                galleryModel.setDescription(rs.getString("description"));
                galleryModel.setName(rs.getString("name"));
                listGallery.add(galleryModel);
            }
            return listGallery;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
    }

    public ArrayList<GalleryModel> findTop3Gallery() throws SQLException  {
        try {
         // String sqlQuery = "Select Top 3 * from Gallery order by checksum(newid())";          
            String sqlQuery = "Select Top (3) * from Gallery order by id ASC";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            rs = ps.executeQuery();
            ArrayList<GalleryModel> listGallery = new ArrayList<GalleryModel>();
            while (rs.next()) {
                GalleryModel galleryModel = new GalleryModel();
                galleryModel.setId(rs.getInt("id"));
                galleryModel.setTitle(rs.getString("title"));
                galleryModel.setDescription(rs.getString("description"));
                galleryModel.setName(rs.getString("name"));
                listGallery.add(galleryModel);
            }
            return listGallery;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
    }

    public GalleryModel findById(Integer id)
    {
        try {
            String sqlQuery = "Select * from Gallery where id = ?";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            GalleryModel galleryModel = new GalleryModel();
            while (rs.next()) {
                galleryModel.setId(rs.getInt("id"));
                galleryModel.setTitle(rs.getString("title"));
                galleryModel.setDescription(rs.getString("description")); 
                galleryModel.setName(rs.getString("name"));
            }
            return galleryModel;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                db.closeConnection(rs, ps, cnn);
            } catch (SQLException ex) {
                Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        
        GalleryDAO o1 = new GalleryDAO();
        ArrayList<GalleryModel> list = o1.findTop3Gallery();
        System.out.println(list.get(0).getId());
    }
    
}
