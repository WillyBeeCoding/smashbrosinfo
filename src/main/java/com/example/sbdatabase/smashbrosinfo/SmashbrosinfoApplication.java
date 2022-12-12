package com.example.sbdatabase.smashbrosinfo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class SmashbrosinfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmashbrosinfoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CharacterRepo charRepo, MongoTemplate mongoTemplate) {
		return args -> {
			Character character = new Character(
					1,
					"Mario",
					"Super Mario Bros",
					List.of("Luigi", "Peach", "Bowser", "Yoshi", "Daisy", "Bowser Jr.", "Rosalina & Luma")
			);

			Query query = new Query();
			query.addCriteria(Criteria.where("rosterNum").is(1));

			List<Character> chars = mongoTemplate.find(query, Character.class);

			if (chars.isEmpty()) {
				System.out.println("A NEW CHALLENGER HAS APPEARED: " + character.getName().toUpperCase());
				charRepo.insert(character);
			} else if (chars.size() > 1) {
				throw new IllegalStateException("Found multiple characters with the same roster number: " + "1");
			} else {
				System.out.println(character.getName().toUpperCase() + " IS IN THE FIGHT ALREADY!");
			}


		};
	}

}
