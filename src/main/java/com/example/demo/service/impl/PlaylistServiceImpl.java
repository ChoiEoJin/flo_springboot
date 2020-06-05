package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PlaylistDTO;
import com.example.demo.model.Playlist;
import com.example.demo.repository.PlaylistRepository;
import com.example.demo.repository.SongRepository;
import com.example.demo.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	PlaylistRepository playlistRepository;

	@Autowired
	SongRepository songRepository;

	@Override
	public List<Playlist> getPlaylistByUserId(int user_id) {

		return playlistRepository.selectPlaylistWhereUserId(user_id);
	}

	@Override
	public int createPlaylist(PlaylistDTO playlist) {

		return playlistRepository.insertPlaylist(playlist);
	}

	@Override
	public int addSongInPlaylist(PlaylistDTO playlist) {

		if (playlist.getAlbum() != null) {
			int albumId = playlist.getAlbum().getId();
			List<String> albumSongs = songRepository.selectSongIdWhereAlbumId(albumId);

			if (playlist.getSongs() != null) {
				playlist.getSongs().addAll(albumSongs);
			} else {
				playlist.setSongs(albumSongs);
			}

		}

		return playlistRepository.insertMapPlaylistSong(playlist);
	}

	@Override
	public int removePlaylist(PlaylistDTO playlist) {

		return playlistRepository.deletePlaylistWhereIdUserID(playlist);
	}

}
