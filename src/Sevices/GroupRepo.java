package Sevices;

import Database.DBConnection;
import Model.Category;
import Model.Group;
import ProjectRepo.ProjectRepo;

import java.sql.*;

public class GroupRepo implements ProjectRepo {
    private Connection conn;

    public GroupRepo() {
        DBConnection dbConnection = DBConnection.getInstance();
        conn = dbConnection.getConn();
    }

    @Override
    public int create(Object obj) {
        ;
        ResultSet rs = null;
        int id = 0;
        String sql = "INSERT INTO category_group(category_id,group_name,group_url) " + "VALUES(?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // set parameters for statement
            pstmt.setString(1, String.valueOf(( (Group) obj).getCategory().getId()));
            pstmt.setString(2, ( (Group) obj).getGroupName());
            pstmt.setString(3, ( (Group) obj).getGroupUrl());


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
