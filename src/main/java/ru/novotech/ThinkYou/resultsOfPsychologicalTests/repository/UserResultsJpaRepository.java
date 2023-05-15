package ru.novotech.ThinkYou.resultsOfPsychologicalTests.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.model.UserResults;

public interface UserResultsJpaRepository extends JpaRepository<UserResults, Long> {

}
