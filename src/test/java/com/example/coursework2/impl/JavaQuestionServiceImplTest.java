package com.example.coursework2.impl;

import com.example.coursework2.model.Question;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceImplTest {
    private JavaQuestionServiceImpl javaQuestionServiceImpl = new JavaQuestionServiceImpl();

    @Test
    void add() {
        Question expected = new Question("Вопрос 1", "Ответ1");
        Question actual = javaQuestionServiceImpl.add("Вопрос 1", "Ответ1");
        assertEquals(expected,actual);
        assertEquals(1, javaQuestionServiceImpl.getAll().size());
        assertTrue(javaQuestionServiceImpl.getAll().contains(expected));
    }

    @Test
    void remove() {
        Question expected = new Question("Вопрос 1", "Ответ1");
        javaQuestionServiceImpl.add(expected);
        Question actual = javaQuestionServiceImpl.remove(expected);
        assertEquals(expected, actual);
        assertEquals(0, javaQuestionServiceImpl.getAll().size());
    }

    @Test
    void getAll() {
        Question question1 = new Question("Вопрос 1", "Ответ1");
        Question question2 = new Question("Вопрос 2", "Ответ2");
        Question question3 = new Question("Вопрос 3", "Ответ3");
        Collection<Question> expected = new HashSet<>(Set.of(question1, question2, question3));
        assertEquals(expected, javaQuestionServiceImpl.getAll());
    }

    @Test
    void getRandomQuestion() {
        Question randomQuestion = javaQuestionServiceImpl.add("Вопрос 1", "Ответ1");
        assertEquals(randomQuestion, javaQuestionServiceImpl.getRandomQuestion());
    }
    @Test
    void getRandomQuestion2(){
        Question question1 = javaQuestionServiceImpl.add("Вопрос 1", "Ответ1");
        Question question2 = javaQuestionServiceImpl.add("Вопрос 2", "Ответ2");
        Collection<Question> expected = new HashSet<>(Set.of(question1, question2));
        Question randomQuestion = javaQuestionServiceImpl.getRandomQuestion();
        assertTrue(expected.contains(randomQuestion));
    }
}