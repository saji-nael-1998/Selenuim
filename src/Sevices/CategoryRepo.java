package Sevices;

import Database.DBConnection;
import Model.Category;
import Model.Website;
import ProjectRepo.ProjectRepo;

import java.sql.*;

public class CategoryRepo implements ProjectRepo {
    private Connection conn;

    public CategoryRepo() {
        DBConnection dbConnection = DBConnection.getInstance();
        conn = dbConnection.getConn();
    }

    @Override
    public int create(Object obj) {
        ;
        ResultSet rs = null;
        int id = 0;
        String sql = "INSERT INTO category(website_id,category,category_url,category_total_flashcards) " + "VALUES(?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // set parameters for statement
            pstmt.setString(1, String.valueOf(( (Category) obj).getWebsite().getWebsiteId()));
            pstmt.setString(2, ( (Category) obj).getCategory());
            pstmt.setString(3, ( (Category) obj).getCategoryUrl());
            pstmt.setString(4, String.valueOf(( (Category) obj).getFlashcardsCount()));

            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {
                // get candidate id
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) id = rs.getInt(1);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
}
