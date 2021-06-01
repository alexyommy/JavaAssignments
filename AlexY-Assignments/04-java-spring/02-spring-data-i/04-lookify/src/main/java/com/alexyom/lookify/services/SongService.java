package com.alexyom.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alexyom.lookify.models.Song;
import com.alexyom.lookify.repositories.SongRepository;

@Service
public class SongService {
	private SongRepository sRepo;
	
	public SongService(SongRepository repo) {
		this.sRepo = repo;
	}
	
	//Get All Songs
	public List<Song> getAllSongs(){
		return this.sRepo.findAll();
	}
	
	//Get one song or return Null if empty
	public Song findSong(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	
	public List<Song> topTenByRating() {
		return sRepo.findTop10ByOrderByRatingDesc();
	}
	public List<Song> songsContainingArtist(String artist) {
		return sRepo.findByArtistContaining(artist);
	}
	
	//Create a Song
	public Song createSong(Song newSong) {
		return this.sRepo.save(newSong);
	}
	
	//Update a Song
	public Song updateSong(Song song) {
		return this.sRepo.save(song);
	}
	
	//Delete a Song
	public void deleteSong(Long id) {
		this.sRepo.deleteById(id);
	}
}
