package com.example.coursework2.impl;

import com.example.coursework2.model.Question;
import com.example.coursework2.service.QuestionService;
import exeption.ExamException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;

    @Mock
    private QuestionService questionService;
    @Test
    void getQuestions() {
        Collection<Question> expectedQuestions = new HashSet<>(Set.of(new Question("Вопрос1", "Ответ1")));
        when(questionService.getAll()).thenReturn(expectedQuestions);
        when(questionService.getRandomQuestion()).thenReturn(new Question("Вопрос1", "Ответ1"));
        assertEquals(questionService.getAll(), examinerServiceImpl.getQuestions(1));

    }

}