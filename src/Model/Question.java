package Model;

public class Question {
    private long id;
    private String question;
    private String answer;
    private Group group;
    public Question(String question, String answer,Group group) {
        this.question = question;
        this.answer = answer;
        this.group=group;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
