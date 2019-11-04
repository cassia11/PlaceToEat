package br.com.placetoeat.api.v1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class Voting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonProperty
    private User user;

    @ManyToOne
    @JsonProperty
    private Place place;

    @ManyToOne
    @JsonProperty
    private Team team;

    @Column(nullable = false, columnDefinition="DATE")
    @JsonProperty
    private String date;

    public Voting(){

    }
    public Voting(User user, Place place, Team team) {
        this.user = user;
        this.place = place;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Voting{" +
                "id=" + id +
                ", user=" + user +
                ", place=" + place +
                ", team=" + team +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object ob) {
        Voting o = (Voting) ob;
        if(this.getDate().equals(o.getDate())){
            if(this.getTeam().equals(o.getTeam())) {
                if(this.getUser().equals(o.getUser())) {
                    return true;
                }
            }
        }
        return false;
    }

}
