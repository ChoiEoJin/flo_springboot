package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.model.Album;
import com.example.demo.repository.AlbumRepository;
import com.example.demo.service.AlbumsService;
import com.example.demo.util.PagingUtil;

@Service
public class AlbumsServiceImpl implements AlbumsService {

	@Autowired
	AlbumRepository albumRepository;

	@Override
	public Map<String, Object> getAlbumForAlbums(String locale, int page) {

		int totalCount = albumRepository.selectAlbumCountWhereLocale(locale);
		int offset = PagingUtil.getOffset(totalCount, page);
		int limit = PagingUtil.getPageSize();

		List<Album> albums = albumRepository.selectAlbumWhereLocale(locale, offset, limit);

		Map<String, String> queryStringMap = new HashMap<String, String>();
		queryStringMap.put("locale", locale);
		queryStringMap.put("page", String.valueOf(page));

		Map<String, String> pageUrlMap = PagingUtil.generatePageUrl(totalCount, queryStringMap);

		Map<String, Object> bodyMap = new LinkedHashMap<String, Object>();

		bodyMap.put("statusCode", HttpStatus.OK.value());
		bodyMap.put("pages", pageUrlMap);
		bodyMap.put("albums", albums);

		return bodyMap;
	}

}
