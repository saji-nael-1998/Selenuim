package Model;

public class Website {
    private long websiteId;
    private String websiteURL;
    private String websiteName;
    private long websiteTotalflashcards;
    public Website() {
    }

    public Website(String websiteURL, String websiteName,long websiteTotalflashcards) {
        this.websiteURL = websiteURL;
        this.websiteName = websiteName;
        this.websiteTotalflashcards = websiteTotalflashcards;
    }

    public Website(long websiteId, String websiteURL, String websiteName,long websiteTotalflashcards) {
        this.websiteId = websiteId;
        this.websiteURL = websiteURL;
        this.websiteName = websiteName;
        this.websiteTotalflashcards = websiteTotalflashcards;

    }

    public long getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(long websiteId) {
        this.websiteId = websiteId;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public long getWebsiteTotalflashcards() {
        return websiteTotalflashcards;
    }

    public void setWebsiteTotalflashcards(long websiteTotalflashcards) {
        this.websiteTotalflashcards = websiteTotalflashcards;
    }

    @Override
    public String toString() {
        return "Website{" +
                "websiteId=" + websiteId +
                ", websiteURL='" + websiteURL + '\'' +
                ", websiteName='" + websiteName + '\'' +
                ", websiteTotalflashcards=" + websiteTotalflashcards +
                '}';
    }
}

