package Controller;

import Database.DBConnection;
import Model.Category;
import Model.Website;
import ProjectRepo.ProjectRepo;
import Sevices.CategoryRepo;

import java.sql.*;

public class CategoryController {
    private CategoryRepo categoryRepo;

    public CategoryController() {
        categoryRepo = new CategoryRepo();
    }

    public int create(Category category) {
        return categoryRepo.create(category);
    }
}
