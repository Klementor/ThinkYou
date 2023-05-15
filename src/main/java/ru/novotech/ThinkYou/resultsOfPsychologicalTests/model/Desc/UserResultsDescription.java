package ru.novotech.ThinkYou.resultsOfPsychologicalTests.model.Desc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResultsDescription {
    private Long userId;
    private Long userResultId;
    private FieldDependenceOrFieldIndependence firstCognitiveStyle;
    private String firstCognitiveStyleDescription;
    private ImpulsivityOrReflectivity secondCognitiveStyle;
    private String secondCognitiveStyleDescription;

    public enum FieldDependenceOrFieldIndependence {
        fieldDependence,
        fieldIndependence,

    }

    public enum ImpulsivityOrReflectivity {
        impulsivity,
        reflectivity
    }
}
