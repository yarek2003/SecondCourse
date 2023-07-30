package com.example.coursework2.impl;

import com.example.coursework2.model.Question;
import com.example.coursework2.service.ExaminerService;
import com.example.coursework2.service.QuestionService;
import exeption.ExamException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {


    private final QuestionService javaService;

    private final QuestionService mathService;


    public ExaminerServiceImpl(@Qualifier("javaService") QuestionService javaService,
                               @Qualifier("mathService") QuestionService mathService) {
        this.javaService = javaService;
        this.mathService = mathService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<QuestionService> allQuestionsList = List.of(javaService, mathService);
        int size = allQuestionsList.stream()
                .mapToInt(QuestionService -> QuestionService.getAll().size())
                .sum();
        if (amount > size) {
            throw new ExamException();
        }

        Random random = new Random();
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(allQuestionsList.get(random.nextInt(allQuestionsList.size())).getRandomQuestion());
        }
        return questions;

    }
}