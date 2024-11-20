package com.company.binding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter 
@AllArgsConstructor
@ToString
public class DummyBean {
	private String title ;
    private String artist;
    private String genre;
    private int trackLength; // in seconds
    private String album;
    private String releaseDate;
    private String bassType; // e.g., "Electric Bass", "Synth Bass"
    private int bassIntensity; // Scale of 1 to 10
    private String description;
}