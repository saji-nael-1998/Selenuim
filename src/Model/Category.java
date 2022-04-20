package Model;

public class Category {
    private long id;
    private String category;
    private String categoryUrl;
    private long flashcardsCount;
    private Website website;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public long getFlashcardsCount() {
        return flashcardsCount;
    }

    public void setFlashcardsCount(long flashcardsCount) {
        this.flashcardsCount = flashcardsCount;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }
}
