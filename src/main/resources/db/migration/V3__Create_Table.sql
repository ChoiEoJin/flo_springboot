CREATE TABLE TB_ALBUM (
	album_id  int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	album_title varchar(100)
);



CREATE TABLE TB_LOCALE (
	locale_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	locale varchar(10)
);



CREATE TABLE TB_SONG (
	song_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	song_title varchar(100),
	song_length int,
	song_track int,
	album_id int,
	FOREIGN KEY (album_id) REFERENCES TB_ALBUM (album_id)
);



CREATE TABLE MAP_ALBUM_LOCALE (
	map_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	album_id int,
	locale_id int,
	FOREIGN KEY (album_id) REFERENCES TB_ALBUM (album_id),
	FOREIGN KEY (locale_id) REFERENCES TB_LOCALE (locale_id)
);

CREATE TABLE TB_PLAYLIST (
	playlist_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	playlist_name varchar(100),
	user_id int NOT NULL,
	playlist_sort_seq int NOT NULL,
	created_at datetime DEFAULT NOW(),
	updated_at datetime DEFAULT NOW()
);

CREATE TABLE MAP_PLAYLIST_SONG (
	map_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	playlist_id int,
	song_id int,
	FOREIGN KEY (playlist_id) REFERENCES TB_PLAYLIST (playlist_id) ON DELETE CASCADE,
	FOREIGN KEY (song_id) REFERENCES TB_SONG (song_id) ON DELETE CASCADE,
	created_at datetime DEFAULT NOW(),
	updated_at datetime DEFAULT NOW()
);



