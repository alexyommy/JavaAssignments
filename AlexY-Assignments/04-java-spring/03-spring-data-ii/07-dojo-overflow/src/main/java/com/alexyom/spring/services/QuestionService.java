package com.alexyom.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexyom.spring.models.Answer;
import com.alexyom.spring.models.NewQuestion;
import com.alexyom.spring.models.Question;
import com.alexyom.spring.models.Tag;
import com.alexyom.spring.repositories.AnswerRepository;
import com.alexyom.spring.repositories.QuestionRepository;
import com.alexyom.spring.repositories.TagRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository qRepo;
	@Autowired
	private AnswerRepository aRepo;
	@Autowired
	private TagRepository tRepo;
	
	//Get All Questions
	public List<Question> getAllQuestions() {
		return this.qRepo.findAll();
	}
	
	//Get Single Question
	public Question getSingleQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	
	//Get All Answers
	public List<Answer> getAllAnswers() {
		return this.aRepo.findAll();
	}
	
	//Create Question
	public void createQuestion(NewQuestion question) {
		
		List<Tag> questionTags = new ArrayList<Tag>();
		
		for(String subject: question.splitTags()) {
			Tag tag = this.tRepo.findBySubject(subject).orElse(null);
			
			if(tag == null) {
				tag = new Tag(subject);
				this.tRepo.save(tag);
			
			}
			//Prevents duplicate tag
			if(!questionTags.contains(tag)) {
				questionTags.add(tag);
			}
		}
		Question newQuestion = new Question(question.getQuestion(), questionTags);
		this.qRepo.save(newQuestion);
	}
	
	//Create Answer
	public Answer createAnswer(Answer answer) {
		
		return this.aRepo.save(answer);
	}
}
