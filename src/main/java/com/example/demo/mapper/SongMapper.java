package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.Song;

@Mapper
public interface SongMapper {

	List<Song> selectSongWhereLocaleTitle(@Param("locale") String locale, @Param("title") String title);

	List<String> selectSongIdWhereAlbumId(@Param("albumId") int songId);

}
