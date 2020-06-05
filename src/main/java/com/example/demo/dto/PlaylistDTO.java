package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Album;

import lombok.Getter;
import lombok.Setter;

/**
 * 플레이리스트 테이블에 대해 DML을 수행하기 위해 생성된 DTO 
 */
@Getter
@Setter
public class PlaylistDTO {

	private String playlistId;
	private String userId;
	private String playlistName;
	private List<String> songs;
	private Album album;

}
