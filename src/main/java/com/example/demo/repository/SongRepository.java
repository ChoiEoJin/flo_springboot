package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.mapper.SongMapper;
import com.example.demo.model.Song;

@Repository
public class SongRepository {

	@Autowired
	SongMapper songMapper;

	public List<Song> selectSongWhereLocaleTitle(String locale, String title) {

		return songMapper.selectSongWhereLocaleTitle(locale, title);
	}

	public List<String> selectSongIdWhereAlbumId(int albumId) {

		return songMapper.selectSongIdWhereAlbumId(albumId);
	}

}
