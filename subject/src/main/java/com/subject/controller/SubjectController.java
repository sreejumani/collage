package com.subject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subject.entity.Subject;
import com.subject.repository.SubjectRepository;

@CrossOrigin(origins ="*")

@RequestMapping("/home")
@RestController

public class SubjectController {
	@Autowired
	private SubjectRepository subjectRepository;
	@GetMapping("/get")
	public String home() {
		return("welcome to springboot");
	}
	@PostMapping("/saveSubject")
	public Subject saveData(@RequestBody Subject subject) {
		 return subjectRepository.save(subject);
		 //return subject;
		
	}
	@GetMapping("/getAllsubject")
	 public List<Subject> getAll(){
		List<Subject> subjectList=subjectRepository.findAll();
				return subjectList;
	}
	@GetMapping("/getSubject/{rollno}")
	public Subject getSubjectData(@PathVariable int rollno) {
		Optional<Subject>subject=subjectRepository.findById(rollno);
		Subject subject1=subject.get();
		return subject1;
	}
	@PutMapping("/updateSubject/{rollno}")
	public ResponseEntity<Subject> updateSubject(@PathVariable Integer rollno, @RequestBody Subject userDetails) {
        Optional<Subject> existingSubjectOpt = subjectRepository.findById(rollno);
        
        if (existingSubjectOpt.isPresent()) {
            Subject existingSubject = existingSubjectOpt.get();
            
            
            existingSubject.setRollno(userDetails.getRollno());
            existingSubject.setName(userDetails.getName());
            existingSubject.setMarks(userDetails.getMarks());
            
            
            Subject updatedSubject = subjectRepository.save(existingSubject);
            
            return ResponseEntity.ok(updatedSubject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

		
	
	@DeleteMapping("/deleteSubject/{rollno}")
		public String deleteSubjectData(@PathVariable int rollno) {
		Subject subject=subjectRepository.findById(rollno).get();
		if(subject!=null)
			subjectRepository.delete(subject);	
			return "Deleted data for"+ rollno;
		}
				
	}
	


