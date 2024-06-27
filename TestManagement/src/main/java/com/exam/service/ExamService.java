package com.exam.service;


import java.util.*;

import org.springframework.http.ResponseEntity;

import com.exam.model.Exam;


public interface ExamService {
    
    //add questions in database
    public boolean addQuestion(Exam exam);

    //view all questions
    public List<Exam> viewAllQuestions();

    //view question by id 
    public Optional<Exam> viewQuestionById(int question_id);

    //delete question by id
    public ResponseEntity<?> deleteQuestion(int question_id);

    //update questions by id
    public boolean updateQuestion(int question_id, Exam exam);

}
