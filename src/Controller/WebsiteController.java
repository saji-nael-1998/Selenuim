package Controller;

import Database.DBConnection;
import Model.Website;
import ProjectRepo.ProjectRepo;
import Sevices.WebsiteRepo;

import java.sql.*;

public class WebsiteController {
    private WebsiteRepo websiteRepo;

    public WebsiteController() {
        websiteRepo = new WebsiteRepo();
    }


    public int create(Website website) {

        return websiteRepo.create(website);

    }
}
