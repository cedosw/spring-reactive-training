package de.engineeringos.training.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieEvent {
    private String movieId;
    
    private Date date;
}
