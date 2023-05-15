package ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto.Desc;

import ru.novotech.ThinkYou.resultsOfPsychologicalTests.model.Desc.UserResultsDescription;

public class UserResultsDescriptionMapper {

    public static UserResultsDescriptionResponseDto toUserResultDescriptionResponseDto(UserResultsDescription userResultsDescription) {
        UserResultsDescriptionResponseDto userResultsDescriptionResponseDto = new UserResultsDescriptionResponseDto();

        userResultsDescriptionResponseDto.setUserId(userResultsDescription.getUserId());
        userResultsDescriptionResponseDto.setUserResultId(userResultsDescription.getUserResultId());
        userResultsDescriptionResponseDto.setFirstCognitiveStyle(userResultsDescription.getFirstCognitiveStyle());
        userResultsDescriptionResponseDto.setFirstCognitiveStyleDesc(userResultsDescription.getFirstCognitiveStyleDescription());
        userResultsDescriptionResponseDto.setSecondCognitiveStyle(userResultsDescription.getSecondCognitiveStyle());
        userResultsDescriptionResponseDto.setSecondCognitiveStyleDesc(userResultsDescription.getSecondCognitiveStyleDescription());

        return userResultsDescriptionResponseDto;
    }
}
