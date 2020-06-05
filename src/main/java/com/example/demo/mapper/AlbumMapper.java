package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.Album;

@Mapper
public interface AlbumMapper {

	/**
	 * locale과 title로 앨범 조회.
	 */
	List<Album> selectAlbumWhereLocaleTitle(@Param("locale") String locale, @Param("title") String title);

	/**
	 * 페이징 처리 위해 앨범 총 개수 카운트.
	 */
	int selectAlbumCountWhereLocale(@Param("locale") String locale);

	/**
	 * locale로 앨범 조회.
	 */
	List<Album> selectAlbumWhereLocale(@Param("locale") String locale, @Param("offset") int offset, @Param("limit") int limit);

}
