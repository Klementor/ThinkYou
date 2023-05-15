package ru.novotech.ThinkYou.resultsOfPsychologicalTests.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.novotech.ThinkYou.exception.NotFoundException;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto.Desc.UserResultsDescriptionMapper;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto.Desc.UserResultsDescriptionResponseDto;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto.UserResultsMapper;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto.UserResultsRequestDto;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto.UserResultsResponseDto;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.model.Desc.UserResultsDescription;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.model.UserResults;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.repository.CognitiveStyleDescriptionJpaRepository;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.repository.UserResultsJpaRepository;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.service.UserResultsService;
import ru.novotech.ThinkYou.user.repository.UserJpaRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserResultsServiceImpl implements UserResultsService {

    private final UserResultsJpaRepository userResultsJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final CognitiveStyleDescriptionJpaRepository cognitiveStyleDescriptionJpaRepository;

    @Override
    @Transactional
    public UserResultsResponseDto addUserResults(UserResultsRequestDto userResultsRequestDto, Long userId) {
        checkUserExistsById(userId);
        UserResults userResults = userResultsJpaRepository.save(UserResultsMapper.fromUserResultRequestDto(userResultsRequestDto, userId));
        log.debug("Результаты пользователя с id= {} добавлены", userResults.getUserId());
        return UserResultsMapper.toUserResultResponseDto(userResults);
    }

    @Override
    @Transactional
    public UserResultsResponseDto updateUserResults(UserResultsRequestDto userResultsRequestDto, Long userId, Long userResultsId) {
        checkUserExistsById(userId);
        UserResults userResults = userResultsJpaRepository.getReferenceById(userResultsId);
        Optional.of(userResultsRequestDto.getCorrectClicks()).ifPresent(userResults::setCorrectClicks);
        Optional.of(userResultsRequestDto.getIncorrectClicks()).ifPresent(userResults::setIncorrectClicks);
        Optional.of(userResultsRequestDto.getOmissions()).ifPresent(userResults::setOmissions);
        Optional.of(userResultsRequestDto.getAverageReactionTime()).ifPresent(userResults::setAverageReactionTime);
        UserResults updateUserResults = userResultsJpaRepository.save(userResults);
        log.debug("Обновлены данные пользователя с id = {}", userId);
        return UserResultsMapper.toUserResultResponseDto(updateUserResults);
    }

    @Override
    @Transactional
    public UserResultsResponseDto getUserResultsById(Long userId, Long userResultsId) {
        checkUserExistsById(userId);
        checkUserResultExistsById(userResultsId);
        log.debug("Результаты пользователя с id = {} отправлены", userId);
        return UserResultsMapper.toUserResultResponseDto(userResultsJpaRepository.getReferenceById(userResultsId));
    }

    @Override
    @Transactional
    public void deleteUserResultsById(Long userId, Long userResultsId) {
        checkUserExistsById(userId);
        checkUserResultExistsById(userResultsId);
        log.debug("Удалены результаты тестов пользователя с id= {}", userId);
        userResultsJpaRepository.deleteById(userResultsId);
    }

    @Override
    @Transactional
    public List<UserResultsResponseDto> getUsersResults() {
        log.debug("Отправлены результаты тестов всех пользователей");
        return UserResultsMapper.toUserResultResponseDtoList(userResultsJpaRepository.findAll());
    }

    @Override
    @Transactional
    public UserResultsDescriptionResponseDto getUsersResultsDescription(Long userId, Long userResultsId) {
        UserResultsResponseDto userResults = getUserResultsById(userId, userResultsId);

        UserResultsDescription userResultsDescription = new UserResultsDescription();
        userResultsDescription.setUserId(userId);
        userResultsDescription.setUserResultId(userResultsId);

        if (userResults.getCorrectClicks() >= userResults.getIncorrectClicks() + userResults.getOmissions()) {
            userResultsDescription.setFirstCognitiveStyle(UserResultsDescription.FieldDependenceOrFieldIndependence.fieldIndependence);
            userResultsDescription.setFirstCognitiveStyleDescription(
                    cognitiveStyleDescriptionJpaRepository.findAllByStyleIs(
                            userResultsDescription.getFirstCognitiveStyle().toString()).getDescription());
        } else {
            userResultsDescription.setFirstCognitiveStyle(UserResultsDescription.FieldDependenceOrFieldIndependence.fieldDependence);
            userResultsDescription.setFirstCognitiveStyleDescription(
                    cognitiveStyleDescriptionJpaRepository.findAllByStyleIs(
                            userResultsDescription.getFirstCognitiveStyle().toString()).getDescription());
        }
        if (userResults.getAverageReactionTime() <= 0.3) {
            userResultsDescription.setSecondCognitiveStyle(UserResultsDescription.ImpulsivityOrReflectivity.impulsivity);
            userResultsDescription.setSecondCognitiveStyleDescription(
                    cognitiveStyleDescriptionJpaRepository.findAllByStyleIs(
                            userResultsDescription.getSecondCognitiveStyle().toString()).getDescription());
        } else {
            userResultsDescription.setSecondCognitiveStyle(UserResultsDescription.ImpulsivityOrReflectivity.reflectivity);
            userResultsDescription.setSecondCognitiveStyleDescription(
                    cognitiveStyleDescriptionJpaRepository.findAllByStyleIs(
                            userResultsDescription.getSecondCognitiveStyle().toString()).getDescription());
        }
        return UserResultsDescriptionMapper.toUserResultDescriptionResponseDto(userResultsDescription);
    }

    private void checkUserExistsById(Long userId) {
        if (!userJpaRepository.existsById(userId)) {
            throw new NotFoundException("Пользователя с таким id не существует");
        }
    }

    private void checkUserResultExistsById(Long userResultsId) {
        if (!userResultsJpaRepository.existsById(userResultsId)) {
            throw new NotFoundException("Результатов тестов с таким id не существует");
        }
    }
}
