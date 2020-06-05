package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AlbumsService;
import com.example.demo.util.ResponseMapper;

@RequestMapping(value = "/albums")
@RestController
public class AlbumsController {

	@Autowired
	AlbumsService albumsService;

	/**
	 * GET /albums
	 * 지역에 따른 앨범 목록.10개 씩 페이징.
	 * @param locale String NOT NULL
	 * @param page int default 1
	 */
	@GetMapping
	ResponseEntity<Object> albums(@RequestParam(value = "locale", required = true) String locale, @RequestParam(value = "page", required = true, defaultValue = "1") int page) throws Exception {

		if ("".equals(locale.trim())) {
			return ResponseMapper.errorResponse(HttpStatus.BAD_REQUEST.value());
		}

		Map<String, Object> bodyMap = albumsService.getAlbumForAlbums(locale, page);

		return ResponseMapper.sucessResponse(bodyMap);
	}

}
