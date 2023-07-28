package com.example.coursework2.impl;

import com.example.coursework2.model.Question;
import com.example.coursework2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
@Component("mathService")
public class MathQuestionService implements QuestionService {
    private final List<Question> mathQuestionsStorage = new ArrayList<>();
    @Override
    public Question add (String question, String answer){
        Question addQuestion = new Question(question, answer);
        mathQuestionsStorage.add(addQuestion);
        return addQuestion;
    }
    @Override
    public Question add (Question question){
        mathQuestionsStorage.add(question);
        return question;
    }
    @Override
    public Question remove(Question question) {
        if (mathQuestionsStorage.contains(question)) {
            mathQuestionsStorage.remove(question);
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionsStorage;
    }

    @Override
    public Question getRandomQuestion() {
        int random = new Random().nextInt(mathQuestionsStorage.size());
        return mathQuestionsStorage.get(random);
    }

}
