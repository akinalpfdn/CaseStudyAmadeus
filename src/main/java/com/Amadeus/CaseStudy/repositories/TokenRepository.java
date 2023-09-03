package com.Amadeus.CaseStudy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Amadeus.CaseStudy.model.Token;

public interface TokenRepository extends JpaRepository<Token,Long>{

		@Query(value = "Select t from Token t "
			+ "Where t.token = :token "
			)
	public List<Token> getByToken(@Param("token")String token 
			);

}
