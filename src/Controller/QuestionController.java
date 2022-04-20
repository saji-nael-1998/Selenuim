package Controller;

import Model.Question;
import Sevices.QuestionRepo;

public class QuestionController {
    private QuestionRepo questionRepo;

    public QuestionController() {
        questionRepo = new QuestionRepo();
    }

    public int create(Question question) {
        return questionRepo.create(question);
    }
}
