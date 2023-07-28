package com.example.coursework2.impl;

import com.example.coursework2.model.Question;
import com.example.coursework2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Component("javaService")
public class JavaQuestionServiceImpl implements QuestionService {
    private final Set<Question> questionsStorage = new HashSet<>();
    @Override
    public Question add (String question, String answer){
    Question addQuestion = new Question(question, answer);
    questionsStorage.add(addQuestion);
    return addQuestion;
    }
    @Override
    public Question add (Question question){
        questionsStorage.add(question);
        return question;
    }
    @Override
    public Question remove(Question question) {
        if (questionsStorage.contains(question)) {
            questionsStorage.remove(question);
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return questionsStorage;
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = new Random().nextInt(questionsStorage.size());
        List<Question> questionStream = questionsStorage.stream()
                .toList();
        return questionStream.get(randomIndex);
    }


}
