package DAO;

import Model.ImageModel;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import paging.PageRequest;

/**
 *
 * @author NguyenManhCuong
 */
public class ImageDAO {

    // Khai báo các thành phần xử lý DB
    Connection cnn;// Kết nối CSDL
    PreparedStatement ps; // Thực hiện câu lệnh SQL
    ResultSet rs; // Lưu trữ và xử lý dư liệu
    DBContext db = new DBContext();

    public ImageModel findRandomImageByIdGallery(int id) throws Exception {
        try {
            String sqlQuery = "Select Top 1 * from Images where gallery_id = ? order by CHECKSUM(NEWID())";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            ImageModel imageModel = new ImageModel();
            while (rs.next()) {
                imageModel.setId(rs.getInt("id"));
                imageModel.setGallery_id(rs.getInt("gallery_id"));
                imageModel.setUrl(rs.getString("image_url"));
            }
            return imageModel;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
    }

    public int countByIdGallery(Integer id) throws Exception {
        try {
            String sqlQuery = "Select count(*) from Images where gallery_id = ?";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            ps.setInt(1, id);
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

    public List<ImageModel> getImageOffSetByIdGallery(Integer id, PageRequest page) throws Exception {
        try {
            String sqlQuery = "Select * from Images where gallery_id = ? order by id offset ? rows fetch next ? rows only";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            ps.setInt(2, page.getOffset());
            ps.setInt(3, page.getLimit());
            rs = ps.executeQuery();
            List<ImageModel> listImageModel = new ArrayList<ImageModel>();
            while (rs.next()) {
                ImageModel imageModel = new ImageModel();
                imageModel.setId(rs.getInt("id"));
                imageModel.setGallery_id(rs.getInt("gallery_id"));
                imageModel.setUrl(rs.getString("image_url"));
                listImageModel.add(imageModel);
            }
            return listImageModel;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }

    }

    public List<ImageModel> getImageByIdGallery(Integer id) throws Exception {
         try {
            String sqlQuery = "Select * from Images where gallery_id = ?";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            List<ImageModel> listImageModel = new ArrayList<ImageModel>();
            while (rs.next()) {
                ImageModel imageModel = new ImageModel();
                imageModel.setId(rs.getInt("id"));
                imageModel.setGallery_id(rs.getInt("gallery_id"));
                imageModel.setUrl(rs.getString("image_url"));
                listImageModel.add(imageModel);
            }
            return listImageModel;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
        
    }

}
