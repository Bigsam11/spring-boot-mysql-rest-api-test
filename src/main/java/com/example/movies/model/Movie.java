package com.example.movies.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "movie")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"title", "genre"},
        allowGetters = true)

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String title;
    private String genre;
    private String actor;



    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date year_of_release;


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return getGenre();
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActor() {
        return actor;
    }

    public void setYear_of_release(Date year_of_release) {
        this.year_of_release = year_of_release;
    }

    public Date getYear_of_release() {return year_of_release; }


}
