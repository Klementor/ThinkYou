package ru.novotech.ThinkYou.resultsOfPsychologicalTests.model.Desc;

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
@Table(name = "COGNITIVE_STYLE_DESCRIPTION")
public class CognitiveStyleDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "STYLE", nullable = false, length = 50)
    private String style;

    @Column(nullable = false, length = 1000)
    private String description;
}
