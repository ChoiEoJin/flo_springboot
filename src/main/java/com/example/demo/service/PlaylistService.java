package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PlaylistDTO;
import com.example.demo.model.Playlist;

public interface PlaylistService {

	List<Playlist> getPlaylistByUserId(int user_id);

	int createPlaylist(PlaylistDTO playlist);

	int addSongInPlaylist(PlaylistDTO playlist);

	int removePlaylist(PlaylistDTO playlist);

}
