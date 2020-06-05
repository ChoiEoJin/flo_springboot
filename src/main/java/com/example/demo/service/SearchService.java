package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.model.Album;
import com.example.demo.model.Song;

public interface SearchService {

	List<Album> getAlbumForSearch(String locale, String title);

	List<Song> getSongForSearch(String locale, String title);

	Map<String, Object> getSearchResult(String locale, String title);

}
