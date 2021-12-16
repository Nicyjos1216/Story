package com.demo.story.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.demo.story.dto.AdminDTO;
import com.demo.story.dto.AdminStoryDTO;

import com.demo.story.dto.LoginDTO;
import com.demo.story.service.AdminService;



@RestController
@CrossOrigin
public class AdminController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Environment environment;
	@Autowired
	AdminService adminService;
	
	
	
	// Create a new customer
	@PostMapping(value = "/admin",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCustomer(@RequestBody AdminDTO adminDTO) {
		logger.info("Creation request for admin {}", adminDTO);
		adminService.createAdmin(adminDTO);
	}

	// Login
	@PostMapping(value = "/admin/login",consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody LoginDTO loginDTO) {
		logger.info("Login request for admin {} with password {}", loginDTO.getPhoneNo(),loginDTO.getPassword());
		return adminService.login(loginDTO);
	}
	/*
	//Fetches stories by name
	@RequestMapping(value = "/admin/{storyTitle}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AdminStoryDTO>> getByProductName(@PathVariable String storyTitle)throws Exception {
			try {
				logger.info("story request with name {}", storyTitle);
				List<AdminStoryDTO> adminStoryDTO = adminService.getStoryByName(storyTitle);
				return new ResponseEntity<>(adminStoryDTO, HttpStatus.OK);
			} catch (Exception exception) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()),
						exception);
			}
	}




// fetches all stories
	@GetMapping(value = "/story", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AdminStoryDTO>> getAllStory() throws Exception {
		try {
			logger.info("Fetching all stories");
			List<AdminStoryDTO> adminStoryDTOs = adminService.getAllStory();
			return new ResponseEntity<>(adminStoryDTOs, HttpStatus.OK);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()),
					exception);
		}
	}
*/	
}
