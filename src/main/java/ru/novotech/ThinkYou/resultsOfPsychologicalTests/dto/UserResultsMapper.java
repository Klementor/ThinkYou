package ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto;

import ru.novotech.ThinkYou.resultsOfPsychologicalTests.model.UserResults;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserResultsMapper {
    public static UserResults fromUserResultRequestDto(UserResultsRequestDto userResultsRequestDto, Long userId) {
        UserResults userResults = new UserResults();

        userResults.setUserId(userId);
        userResults.setOmissions(userResultsRequestDto.getOmissions());
        userResults.setCorrectClicks(userResultsRequestDto.getCorrectClicks());
        userResults.setIncorrectClicks(userResultsRequestDto.getIncorrectClicks());
        userResults.setAverageReactionTime(userResultsRequestDto.getAverageReactionTime());

        return userResults;
    }

    public static UserResultsResponseDto toUserResultResponseDto(UserResults userResults) {
        UserResultsResponseDto userResultsResponseDto = new UserResultsResponseDto();

        userResultsResponseDto.setUserResultsId(userResults.getResultId());
        userResultsResponseDto.setUserId(userResults.getUserId());
        userResultsResponseDto.setCorrectClicks(userResults.getCorrectClicks());
        userResultsResponseDto.setIncorrectClicks(userResults.getIncorrectClicks());
        userResultsResponseDto.setOmissions(userResults.getOmissions());
        userResultsResponseDto.setAverageReactionTime(userResults.getAverageReactionTime());

        return userResultsResponseDto;
    }

    public static List<UserResultsResponseDto> toUserResultResponseDtoList(Collection<UserResults> userResultsList) {
        return userResultsList.stream()
                .map(UserResultsMapper::toUserResultResponseDto)
                .collect(Collectors.toList());
    }
}
