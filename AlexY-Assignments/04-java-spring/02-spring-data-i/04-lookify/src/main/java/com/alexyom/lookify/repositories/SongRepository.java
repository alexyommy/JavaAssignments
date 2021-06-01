package com.alexyom.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexyom.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();
	List<Song> findTop10ByOrderByRatingDesc();
	List<Song> findByArtistContaining(String artist);
}
