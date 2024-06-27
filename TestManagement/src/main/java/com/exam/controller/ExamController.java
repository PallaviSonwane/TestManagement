package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Exam;
import java.util.Optional;
import java.util.List;
import com.exam.service.ExamService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamService service;

    @PostMapping("/addQuestion")
    public void addQuestions(@RequestBody Exam exam){
        boolean b=service.addQuestion(exam);
       System.out.println( b?"data save properly ":"data not save");
    }

    @GetMapping("/viewQuestion")
    public List<Exam> viewAllQuestions(){
        return service.viewAllQuestions();
    }

     @GetMapping("/viewById/{question_id}")
    public Optional<Exam> viewQuestionById(@PathVariable("question_id") int question_id){
        return service.viewQuestionById(question_id);
    }

    @DeleteMapping("/deleteById/{question_id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("question_id") int question_id){
        ResponseEntity<?> response = service.deleteQuestion(question_id);
        return response;
    }

    @PutMapping("/updateById/{question_id}")
     public void updateQuestion(@PathVariable int question_id,@RequestBody Exam exam){
            boolean b=service.updateQuestion(question_id, exam);
            System.out.println(b?"update":"notttt");
    }
    
}
