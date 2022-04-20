package Model;

public class Group {
    private long id;
    private String groupName;
    private String groupUrl;
    private Category category;
    public Group(String groupName, String groupUrl,Category category) {
        this.groupName = groupName;
        this.groupUrl = groupUrl;
        this.category=category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupUrl() {
        return groupUrl;
    }

    public void setGroupUrl(String groupUrl) {
        this.groupUrl = groupUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
