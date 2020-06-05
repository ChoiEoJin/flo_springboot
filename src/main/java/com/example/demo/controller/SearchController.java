package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SearchService;
import com.example.demo.util.ResponseMapper;

@RequestMapping(value = "/search")
@RestController
public class SearchController {

	@Autowired
	SearchService searchService;

	/**
	 * GET /search
	 * 지역과 제목에 따른 앨범, 곡 검색 요
	 * @param title String NOT NULL 
	 * @param locale String NOT NULL
	 */
	@GetMapping
	ResponseEntity<Object> search(@RequestParam(value = "locale", required = true) String locale, @RequestParam(value = "title", required = true) String title) {

		if ("".equals(locale.trim()) || "".equals(title.trim())) {
			return ResponseMapper.errorResponse(HttpStatus.BAD_REQUEST.value());
		}

		Map<String, Object> bodyMap = searchService.getSearchResult(locale, title);

		return ResponseMapper.sucessResponse(bodyMap);
	}

}
