package org.sandopla.rockrest;

import jakarta.persistence.*;

@Entity
public class Score {

    @Id
    @SequenceGenerator(
            name = "score_sequence",
            sequenceName = "score_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "score_sequence"
    )
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Score(int wins, int ties, int losses) {
        this.wins = wins;
        this.ties = ties;
        this.losses = losses;
    }

    public Score() {

    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    int wins;
    int ties;
    int losses;

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", wins=" + wins +
                ", losses=" + losses +
                ", ties=" + ties +
                '}';
    }
}
