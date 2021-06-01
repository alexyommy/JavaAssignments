package com.alexyom.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexyom.lookify.models.Song;
import com.alexyom.lookify.services.SongService;

@RestController
@RequestMapping("/api")
public class APISongController {
	@Autowired
	private SongService sService;
	
	@GetMapping("")
	public List<Song> index() {
		return this.sService.getAllSongs();
	}
	
	@GetMapping("/id")
	public Song getSong(@PathVariable("id") Long id) {
		return this.sService.findSong(id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteSong(@PathVariable("id") Long id) {
		this.sService.deleteSong(id);
	}
	
	@PutMapping("/update/{id}")
	public Song updateSong(@PathVariable("id") Long id, Song updatedSong) {
		return this.sService.updateSong(updatedSong);
	}
}
