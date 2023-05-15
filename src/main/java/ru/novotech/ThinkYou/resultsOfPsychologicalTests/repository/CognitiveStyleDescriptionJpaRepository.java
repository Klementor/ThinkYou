package ru.novotech.ThinkYou.resultsOfPsychologicalTests.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.model.Desc.CognitiveStyleDescription;

public interface CognitiveStyleDescriptionJpaRepository extends JpaRepository<CognitiveStyleDescription, Long> {

    CognitiveStyleDescription findAllByStyleIs(String cognitiveStyle);
}

