package ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto.Desc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.model.Desc.UserResultsDescription;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResultsDescriptionResponseDto {
    private Long userId;
    private Long userResultId;
    private UserResultsDescription.FieldDependenceOrFieldIndependence firstCognitiveStyle;
    private String firstCognitiveStyleDesc;
    private UserResultsDescription.ImpulsivityOrReflectivity secondCognitiveStyle;
    private String secondCognitiveStyleDesc;
}
