package com.example.coursework2.impl;

import com.example.coursework2.model.Question;
import com.example.coursework2.repository.QuestionRepository;
import com.example.coursework2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
@Component("mathService")
public class MathQuestionService implements QuestionService {
    private final QuestionRepository repository;

    public MathQuestionService(@Qualifier("mathRepository") QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add (String question, String answer){
        Question addQuestion = new Question(question, answer);
        repository.add(addQuestion);
        return addQuestion;
    }
    @Override
    public Question add (Question question){
        repository.add(question);
        return question;
    }
    @Override
    public Question remove(Question question) {

        return repository.remove(question);

    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        var allQuestions = repository.getAll();
        int randomIndex = new Random().nextInt(allQuestions.size());
        List<Question> questionStream = allQuestions.stream()
                .toList();
        return questionStream.get(randomIndex);
    }

}
