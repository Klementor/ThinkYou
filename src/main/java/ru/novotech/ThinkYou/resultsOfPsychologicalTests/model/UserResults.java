package ru.novotech.ThinkYou.resultsOfPsychologicalTests.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_results")
public class UserResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id", nullable = false)
    private Long resultId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "correct_clicks")
    private int correctClicks;
    @Column(name = "incorrect_clicks")
    private int incorrectClicks;
    @Column(name = "omissions")
    private int omissions;
    @Column(name = "average_reaction_time")
    private double averageReactionTime;
}
