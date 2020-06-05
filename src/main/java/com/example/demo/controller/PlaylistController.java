package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PlaylistDTO;
import com.example.demo.model.Playlist;
import com.example.demo.service.PlaylistService;
import com.example.demo.util.ResponseMapper;

/**
 * /playlist 요청 처리 컨트롤러. 
 * 해당 컨트롤러에서 제어하는 요청은 Header의 Authoriztion에 LOGGED_IN을 필요로 한다. 
 */
@RequestMapping("/playlist")
@RestController
public class PlaylistController {

	@Autowired
	PlaylistService playlistService;

	
	/**
	 * GET /playlist/{user_id}
	 * 유저별 플레이 리스트 목록
	 * @param user_id int NOT NULL
	 */
	@GetMapping("/{user_id}")
	ResponseEntity<Object> playlist(@PathVariable("user_id") int user_id) {

		List<Playlist> playlists = playlistService.getPlaylistByUserId(user_id);

		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
		responseMap.put("statusCode", HttpStatus.OK.value());
		responseMap.put("playlists", playlists);

		return ResponseMapper.sucessResponse(responseMap);
	}

	/**
	 * GET /playlist/create
	 * 플레이 리스트 생성
	 * @param platlistName String NOT NULL 
	 * @param userId int NOT NULL 
	 */
	@PostMapping("/create")
	ResponseEntity<Object> createPlaylist(@RequestBody PlaylistDTO playlist) {

		if (playlist.getPlaylistName() == null || "".equals(playlist.getPlaylistName().trim()) || playlist.getUserId() == null || "".equals(playlist.getUserId())) {

			return ResponseMapper.errorResponse(HttpStatus.BAD_REQUEST.value());
		}

		int result = playlistService.createPlaylist(playlist);

		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
		responseMap.put("statusCode", HttpStatus.OK.value());
		responseMap.put("resultCount", result);

		return ResponseMapper.sucessResponse(responseMap);
	}

	/**
	 * GET /playlist/addsong
	 * 플레이 리스트에 곡 추가
	 * @param platlistId int NOT NULL 
	 * @param songs Array 
	 * @param album.id String 
	 */
	@PostMapping("/addsong")
	ResponseEntity<Object> addSongInPlaylist(@RequestBody PlaylistDTO playlist) {

		if (playlist.getPlaylistId() == null || "".equals(playlist.getPlaylistId().trim()) || (playlist.getSongs() == null && playlist.getAlbum() == null)) {

			return ResponseMapper.errorResponse(HttpStatus.BAD_REQUEST.value());
		}

		int result = playlistService.addSongInPlaylist(playlist);

		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
		responseMap.put("statusCode", HttpStatus.OK.value());
		responseMap.put("resultCount", result);

		return ResponseMapper.sucessResponse(responseMap);
	}

	/**
	 * GET /playlist/remove
	 * 플레이 리스트 삭제
	 * @param platlistId int NOT NULL 
	 * @param userId int NOT NULL 
	 */
	@PostMapping("/remove")
	ResponseEntity<Object> removePlaylist(@RequestBody PlaylistDTO playlist) {

		if (playlist.getPlaylistId() == null || "".equals(playlist.getPlaylistId().trim()) || playlist.getUserId() == null || "".equals(playlist.getUserId().trim())) {
			return ResponseMapper.errorResponse(HttpStatus.BAD_REQUEST.value());
		}

		int result = playlistService.removePlaylist(playlist);

		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
		responseMap.put("statusCode", HttpStatus.OK.value());
		responseMap.put("resultCount", result);

		return ResponseMapper.sucessResponse(responseMap);
	}

}
