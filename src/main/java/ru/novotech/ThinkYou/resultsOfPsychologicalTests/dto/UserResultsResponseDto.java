package ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResultsResponseDto {
    private Long userResultsId;
    private Long userId;
    private int correctClicks;
    private int incorrectClicks;
    private int omissions;
    private double averageReactionTime;
}
