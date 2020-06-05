package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.PlaylistDTO;
import com.example.demo.model.Playlist;

@Mapper
public interface PlaylistMapper {

	List<Playlist> selectPlaylistWhereUserId(@Param("user_id") int user_id);

	int insertPlaylist(PlaylistDTO playlist);

	int insertMapPlaylistSong(PlaylistDTO playlist);

	int deletePlaylistWhereIdUserID(PlaylistDTO playlist);

}
