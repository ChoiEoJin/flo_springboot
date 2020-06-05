package com.example.demo.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Album;
import com.example.demo.model.Song;
import com.example.demo.repository.AlbumRepository;
import com.example.demo.repository.SongRepository;
import com.example.demo.service.SearchService;
import com.example.demo.util.StringUtil;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	AlbumRepository albumRepository;

	@Autowired
	SongRepository songRepository;

	@Override
	public Map<String, Object> getSearchResult(String locale, String title) {

		String likeSearchTitle = StringUtil.generateLikeSearchString(title);

		List<Album> albums = albumRepository.selectAlbumWhereLocaleTitle(locale, likeSearchTitle);
		List<Song> songs = songRepository.selectSongWhereLocaleTitle(locale, likeSearchTitle);

		Map<String, Object> bodyMap = new LinkedHashMap<String, Object>();

		bodyMap.put("albums", albums);
		bodyMap.put("songs", songs);

		return bodyMap;
	}

	@Override
	public List<Album> getAlbumForSearch(String locale, String title) {

		return albumRepository.selectAlbumWhereLocaleTitle(locale, title);
	}

	@Override
	public List<Song> getSongForSearch(String locale, String title) {

		return songRepository.selectSongWhereLocaleTitle(locale, title);
	}

}
