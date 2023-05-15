package ru.novotech.ThinkYou.resultsOfPsychologicalTests.service;

import ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto.Desc.UserResultsDescriptionResponseDto;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto.UserResultsRequestDto;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto.UserResultsResponseDto;

import java.util.List;

public interface UserResultsService {
    UserResultsResponseDto addUserResults(UserResultsRequestDto userResultsRequestDto, Long userId);

    UserResultsResponseDto updateUserResults(UserResultsRequestDto userResultsRequestDto, Long userId, Long userResultsId);

    UserResultsResponseDto getUserResultsById(Long userId, Long userResultsId);

    void deleteUserResultsById(Long userId, Long userResultsId);

    List<UserResultsResponseDto> getUsersResults();

    UserResultsDescriptionResponseDto getUsersResultsDescription(Long userId, Long userResultsId);
}
