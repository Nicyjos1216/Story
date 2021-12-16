package com.demo.story.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.story.dto.AdminDTO;
import com.demo.story.dto.AdminStoryDTO;
import com.demo.story.dto.LoginDTO;
import com.demo.story.entity.Admin;
import com.demo.story.entity.AdminStory;
import com.demo.story.repository.AdminRepository;
import com.demo.story.repository.AdminStoryRepository;

@Service
public class AdminService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AdminRepository adminRepo;
	@Autowired
	AdminStoryRepository adminStoryRepo;
	
	public void createAdmin(AdminDTO adminDTO) {
		logger.info("Creation request for customer {}", adminDTO);
		Admin admin = adminDTO.createEntity();
		adminRepo.save(admin);
	}

	// Login
	
	public boolean login(LoginDTO loginDTO) {
		logger.info("Login request for customer {} with password {}", loginDTO.getPhoneNo(),loginDTO.getPassword());
		Optional<Admin> optAdmin = adminRepo.findById(loginDTO.getPhoneNo());
		if (optAdmin.isPresent()) {
			Admin admin = optAdmin.get();
			if (admin.getPassword().equals(loginDTO.getPassword())) {
				return true;
			}
		}

		return false;
	}
	
/*
	// Fetches stories by name
		public List<AdminStoryDTO> getStoryByName(@PathVariable String storyTitle) throws Exception{

			logger.info("Storyname request for story {}", storyTitle);

			Iterable<AdminStory> adminStory = adminStoryRepo.findBystoryname(storyTitle);
			List<AdminStoryDTO> adminStoryDTO = new ArrayList<AdminStoryDTO>();

			adminStory.forEach(admins -> {
				adminStoryDTO.add(AdminStoryDTO.valueOf(admins));
			});
			if (adminStoryDTO.isEmpty())
				throw new Exception("Service.STORY_NOT_FOUND");
			return adminStoryDTO;
		}


	//fetches all stories
	public List<AdminStoryDTO> getAllStory()throws Exception {

		Iterable<AdminStory> adminStorys = adminStoryRepo.findAll();
		List<AdminStoryDTO> adminStoryDTOs = new ArrayList<>();

		adminStorys.forEach(adminStory -> {
			AdminStoryDTO adminStoryDTO = AdminStoryDTO.valueOf(adminStory);
			adminStoryDTOs.add(adminStoryDTO);
		});
		if (adminStoryDTOs.isEmpty())
			throw new Exception("Service.STORY_NOT_FOUND");
		logger.info("Story Details : {}", adminStoryDTOs);
		return adminStoryDTOs;
	}
	*/
}