import Controller.CategoryController;
import Controller.GroupController;
import Controller.QuestionController;
import Controller.WebsiteController;
import Model.Category;
import Model.Group;
import Model.Question;
import Model.Website;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Driver {
    private static WebDriver driver;

    public static void main(String[] args) {

        System.out.println("start crawling");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Programmer Saji\\Downloads\\chromedriver_win32(2)\\chromedriver.exe");
        driver = new ChromeDriver();
        //set the website we need
        driver.get("https://www.assignguru.com/mcqs/");
        //set count of total flashcards
        String numText = driver.findElement(By.xpath("/html/body/div/main/div[3]/div/div[1]/form/button[1]")).getText().split(" ")[0];
        //set replace for comma
        numText = numText.replace(",", "");
        //parsing from string to int
        //the total flashcards in the website
        int count = Integer.parseInt(numText);
        //create an object of website
        Website website = new Website("https://www.assignguru.com/mcqs/", "assignguru", count);
        //create controller for website
        WebsiteController websiteController = new WebsiteController();
        //create a new record
        //store the generated id in website object
        website.setWebsiteId(websiteController.create(website));
        //get the category list
        WebElement t = driver.findElement(By.xpath("//*[@id=\"bd-sidebar\"]/ul"));
        //identify child nodes with ./child::* expression in xpath
        List<WebElement> c = t.findElements(By.xpath("./child::*"));
        // iterate child nodes
        for (int counter = 1; counter < c.size(); counter++) {
            //get current category
            WebElement currentItem = driver.findElement(By.xpath("//*[@id=\"bd-sidebar\"]/ul/li[" + counter + "]/a"));
           //create category object
            Category category = new Category();
            category.setCategory(currentItem.getText());
            category.setCategoryUrl(currentItem.getAttribute("href"));
            category.setWebsite(website);
            //navigate to
            driver.navigate().to(currentItem.getAttribute("href"));

            setCategory(category, website);
        }
        driver.quit();
        System.out.println("done");
    }

    public static void setCategory(Category category, Website website) {

        //set count of total flashcards
        String numText = driver.findElement(By.xpath("/html/body/div/main/div[3]/div/div[1]/form/button[1]")).getText().split(" ")[0];
        //set replace for comma
        numText = numText.replace(",", "");
        //parsing from string to int
        int count = Integer.parseInt(numText);
        //create controller
        CategoryController categoryController = new CategoryController();

        category.setId(categoryController.create(category));

        WebElement currentList = driver.findElement(By.xpath("/html/body/div/main/div[3]/div/div[3]"));
        //identify child nodes with ./child::* expression in xpath
        List<WebElement> items = currentList.findElements(By.xpath("./child::*"));
        for (int counter = 1; counter < items.size(); counter++) {

            WebElement currentItem = driver.findElement(By.xpath("/html/body/div/main/div[3]/div/div[3]/div[" + (counter) + "]/a/div/div[1]/p"));
            String group = currentItem.getText();
            WebElement link = driver.findElement(By.xpath("/html/body/div/main/div[3]/div/div[3]/div[" + (counter) + "]/a"));
            driver.navigate().to(link.getAttribute("href"));
            String groupUrl = driver.getCurrentUrl();
            GroupController groupController = new GroupController();
            Group g = new Group(group, groupUrl, category);
            g.setId(groupController.create(g));
            setGroup(g);
        }

    }

    public static void setGroup(Group currentGroup) {
      try {
          QuestionController questionController = new QuestionController();
          WebElement t = driver.findElement(By.xpath("/html/body/div/div/div[1]"));
          //identify child nodes with ./child::* expression in xpath
          List<WebElement> items = t.findElements(By.xpath("./child::*"));
          for (int counter = 2; counter <= items.size(); counter++) {
              WebElement currentQuestion = driver.findElement(By.xpath("/html/body/div/div/div[1]/div["+counter+"]/div/div[1]/div/p[2]"  ));
              WebElement currentAnswer = driver.findElement(By.xpath("/html/body/div/div/div[1]/div["+counter+"]/div/div[2]/div/p[2]"));
              Question question = new Question(currentQuestion.getText(), currentAnswer.getText(), currentGroup);
              questionController.create(question);
          }
          driver.navigate().back();
      }catch (Exception e){
          System.out.println(e.getMessage());
      }
    }

}
