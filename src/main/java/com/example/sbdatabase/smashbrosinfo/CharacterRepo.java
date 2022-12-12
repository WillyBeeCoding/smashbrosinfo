package com.example.sbdatabase.smashbrosinfo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterRepo extends MongoRepository<Character, Integer> {

}
