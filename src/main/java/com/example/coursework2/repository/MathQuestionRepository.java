package com.example.coursework2.repository;

import com.example.coursework2.model.Question;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@Component("mathRepository")
public class MathQuestionRepository implements QuestionRepository{
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

}
