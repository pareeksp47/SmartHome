package com.exchange.isep.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.exchange.isep.model.FAQ;

/**
 * 
 * @author Neethu
 *
 */

@Repository
public class FAQRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<FAQ> getFAQ() {

		List<FAQ> result = jdbcTemplate.query("SELECT FAQ from faq ",
				(rs, rowNum) -> new FAQ(rs.getString("faq")));

		return result;

	}

}
