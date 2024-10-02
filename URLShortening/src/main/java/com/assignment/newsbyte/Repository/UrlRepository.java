package com.assignment.newsbyte.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.newsbyte.Model.Url;

public interface UrlRepository extends JpaRepository<Url , Long> {

	
	 public Url findByShortLink(String shortLink);
}
