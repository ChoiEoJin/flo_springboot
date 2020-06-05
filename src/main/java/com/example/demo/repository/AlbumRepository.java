package com.example.demo.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.mapper.AlbumMapper;
import com.example.demo.model.Album;

@Repository
public class AlbumRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(AlbumRepository.class);

	@Autowired
	AlbumMapper albumMapper;

	public List<Album> selectAlbumWhereLocaleTitle(String locale, String title) {
		return albumMapper.selectAlbumWhereLocaleTitle(locale, title);
	}

	public List<Album> selectAlbumWhereLocale(String locale, int offset, int limit) {
		LOGGER.debug("offset: " + offset);
		LOGGER.debug("limit: " + limit);

		return albumMapper.selectAlbumWhereLocale(locale, offset, limit);
	}

	public int selectAlbumCountWhereLocale(String locale) {
		return albumMapper.selectAlbumCountWhereLocale(locale);
	}

}
