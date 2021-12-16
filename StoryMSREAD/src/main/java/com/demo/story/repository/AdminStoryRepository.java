package com.demo.story.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.demo.story.entity.AdminStory;


@Repository
public interface AdminStoryRepository extends JpaRepository<AdminStory, Integer> {

	Iterable<AdminStory> findBystoryname(String storyTitle);

}