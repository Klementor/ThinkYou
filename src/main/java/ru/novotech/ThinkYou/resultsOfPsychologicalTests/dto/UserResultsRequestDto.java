package ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResultsRequestDto {
    @PositiveOrZero
    private int correctClicks;
    @PositiveOrZero
    private int incorrectClicks;
    @PositiveOrZero
    private int omissions;
    @Positive
    private double averageReactionTime;
}
