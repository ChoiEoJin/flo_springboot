package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.PlaylistDTO;
import com.example.demo.mapper.PlaylistMapper;
import com.example.demo.model.Playlist;

@Repository
public class PlaylistRepository {

	@Autowired
	PlaylistMapper playlistMapper;

	public List<Playlist> selectPlaylistWhereUserId(int user_id) {

		return playlistMapper.selectPlaylistWhereUserId(user_id);
	}

	public int insertPlaylist(PlaylistDTO playlist) {

		return playlistMapper.insertPlaylist(playlist);
	}

	public int insertMapPlaylistSong(PlaylistDTO playlist) {

		return playlistMapper.insertMapPlaylistSong(playlist);
	}

	public int deletePlaylistWhereIdUserID(PlaylistDTO playlist) {

		return playlistMapper.deletePlaylistWhereIdUserID(playlist);
	}
}
