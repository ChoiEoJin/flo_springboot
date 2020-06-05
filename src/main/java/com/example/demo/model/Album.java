package com.example.demo.model;

import java.util.List;

import lombok.Getter;

@Getter
public class Album {

	private int id;
	private String title;
	private List<Song> songs;

}
