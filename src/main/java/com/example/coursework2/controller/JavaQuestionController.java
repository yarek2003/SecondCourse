package com.example.coursework2.controller;

import com.example.coursework2.model.Question;
import com.example.coursework2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(@Qualifier("javaService")QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        Question newQuestion = new Question(question, answer);
        questionService.add(newQuestion);
        return newQuestion;
    }
    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question,
                                   @RequestParam String answer) {
        Question removeQuestion = new Question(question, answer);
        return questionService.remove(removeQuestion);
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }

}
