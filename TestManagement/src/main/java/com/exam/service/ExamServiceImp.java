package com.exam.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exam.model.Exam;
import com.exam.repository.ExamRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExamServiceImp implements ExamService{

    @Autowired
    private ExamRepository examRepository;

    //save questions in database
    @Override
    public boolean addQuestion(Exam exam) {
             try{
                examRepository.save(exam);
                     return true;
             }catch(Exception ex){
                 log.error("error in service addquestion {}", ex);
                 return false;
             }
    }

    //get all questions
    @Override
    public List<Exam> viewAllQuestions() {
        return examRepository.findAll();
    }

    //get question by id
    @Override
    public Optional<Exam> viewQuestionById(int question_id) {
        boolean exist=examRepository.existsById(question_id);
        if(exist){
            log.info("i am service");
            return examRepository.findById(question_id);

        }else{
            log.info("error in service");
            return null;
        }
    }

    @Override
    public ResponseEntity<?> deleteQuestion(int question_id) {
        boolean exists = examRepository.existsById(question_id);
        if (exists) {
            log.info("Question deleted in service");
            examRepository.deleteById(question_id);
            return ResponseEntity.ok().build(); // Return ResponseEntity indicating success
        } else {
            log.info("Question not found in service, delete failed");
            return ResponseEntity.notFound().build(); // Return ResponseEntity indicating failure
        }
    }

    @Override
public boolean updateQuestion(int question_id, Exam updatedExam) {
    Optional<Exam> exist = examRepository.findById(question_id);
    
    if (exist.isPresent()) {
        Exam existingExam = exist.get();
        
        // Update the fields of existingExam with the new values from updatedExam
        existingExam.setQuestion(updatedExam.getQuestion());
        // Update other fields as needed
        
        try {
            examRepository.save(existingExam);
            return true;
        } catch (Exception ex) {
            return false;
        }
    } else {
        log.info("Question not found in service, update failed");
        return false;
    }
}


   
    

}
