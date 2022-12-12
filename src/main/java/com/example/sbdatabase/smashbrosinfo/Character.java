package com.example.sbdatabase.smashbrosinfo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document
public class Character {
    @Id
    private String id;
    @Indexed(unique = true)
    private Integer rosterNum;
    private String name;
    private String origin;
    private List<String> associates;

    public Character(Integer rosterNum, String name, String origin, List<String> associates) {
        this.rosterNum = rosterNum;
        this.name = name;
        this.origin = origin;
        this.associates = associates;
    }
}
