package com.example.coursework2.impl;

import com.example.coursework2.model.Question;
import com.example.coursework2.repository.JavaQuestionRepository;
import com.example.coursework2.repository.MathQuestionRepository;
import com.example.coursework2.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceImplTest {
  @InjectMocks
  private MathQuestionRepository repository;

    @Mock
    private QuestionService service;


  private MathQuestionService mathQuestionServiceImpl = new MathQuestionService(repository);

    @BeforeEach
    void setup (){
        MockitoAnnotations.openMocks(this);
        service = new MathQuestionService(repository);
    }
    @Test
    void add() {
        Question expected = new Question("Вопрос 1", "Ответ1");
        Question actual = repository.add("Вопрос 1", "Ответ1");
        assertEquals(expected,actual);
        assertEquals(1, repository.getAll().size());
        assertTrue(repository.getAll().contains(expected));
    }

    @Test
    void remove() {
        Question expected = new Question("Вопрос 1", "Ответ1");
        repository.add(expected);
        Question actual = repository.remove(expected);
        assertEquals(expected, actual);
        assertEquals(0, repository.getAll().size());
    }

    @Test
    void getAll() {
        Question question1 = repository.add("Вопрос 1", "Ответ1");
        Question question2 = repository.add("Вопрос 2", "Ответ2");
        Question question3 = repository.add("Вопрос 3", "Ответ3");
        Collection<Question> questions = new HashSet<>(Set.of(question1, question2, question3));
        assertEquals(questions, repository .getAll());
    }

    @Test
    void getRandomQuestion() {
        Question randomQuestion = service.add("Вопрос 1", "Ответ1");
        assertEquals(randomQuestion, service.getRandomQuestion());
    }
    @Test
    void getRandomQuestion2(){
        Question question1 = repository.add("Вопрос 1", "Ответ1");
        Question question2 = repository.add("Вопрос 2", "Ответ2");
        Collection<Question> expected = new HashSet<>(Set.of(question1, question2));
        Question randomQuestion = service.getRandomQuestion();
        assertTrue(expected.contains(randomQuestion));
    }
}