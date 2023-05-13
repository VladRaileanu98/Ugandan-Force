package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String question;


    private Integer score;

    private Integer noOfChoices;

    @OneToMany
    List<Choice> choiceList = new ArrayList<>();

//    @ManyToOne
//    private Quiz quiz;
    private Integer parentQuizId;

    public void incrementNoOfChoices(){
        this.noOfChoices = this.noOfChoices + 1;
    }

    public void decrementNoOfChoices(){
        this.noOfChoices = this.noOfChoices - 1;
    }
}
