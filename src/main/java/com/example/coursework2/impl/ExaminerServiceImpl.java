package com.example.coursework2.impl;

import com.example.coursework2.model.Question;
import com.example.coursework2.service.ExaminerService;
import com.example.coursework2.service.QuestionService;
import exeption.ExamException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random = new Random();
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new ExamException();
        }
        List<Question> uniqueQuestions = new ArrayList<>();
        while (uniqueQuestions.size() < amount) {
            Question newQuestion = questionService.getRandomQuestion();
            if (!uniqueQuestions.contains(newQuestion)) {
                uniqueQuestions.add(newQuestion);
            }
        }
        return uniqueQuestions;
    }
}
