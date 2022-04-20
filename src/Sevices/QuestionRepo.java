package Sevices;

import Database.DBConnection;
import Model.Group;
import Model.Question;
import ProjectRepo.ProjectRepo;

import java.sql.*;

public class QuestionRepo implements ProjectRepo {
    private Connection conn;

    public QuestionRepo() {
        DBConnection dbConnection = DBConnection.getInstance();
        conn = dbConnection.getConn();
    }
    @Override
    public int create(Object obj) {
        ResultSet rs = null;
        int id = 0;
        String sql = "INSERT INTO question(group_id,question,answer) " + "VALUES(?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // set parameters for statement
            pstmt.setString(1, String.valueOf(( (Question) obj).getGroup().getId()));
            pstmt.setString(2, ( (Question) obj).getQuestion());
            pstmt.setString(3, ( (Question) obj).getAnswer());
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
