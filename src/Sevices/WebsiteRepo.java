package Sevices;

import Database.DBConnection;
import Model.Website;
import ProjectRepo.ProjectRepo;

import java.sql.*;

public class WebsiteRepo implements ProjectRepo {
    private Connection conn;

    public WebsiteRepo() {
        DBConnection dbConnection = DBConnection.getInstance();
        conn = dbConnection.getConn();
    }


    @Override
    public int create(Object obj) {

        Website website = (Website) obj;
        ResultSet rs = null;
        int id = 0;
        String sql = "INSERT INTO website(website_url,website_name,website_total_flashcards) " + "VALUES(?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // set parameters for statement
            pstmt.setString(1, website.getWebsiteURL());
            pstmt.setString(2, website.getWebsiteName());
            pstmt.setString(3, String.valueOf(website.getWebsiteTotalflashcards()));

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
