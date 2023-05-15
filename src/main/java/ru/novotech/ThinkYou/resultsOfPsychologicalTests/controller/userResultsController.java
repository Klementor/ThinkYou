package ru.novotech.ThinkYou.resultsOfPsychologicalTests.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto.Desc.UserResultsDescriptionResponseDto;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto.UserResultsRequestDto;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.dto.UserResultsResponseDto;
import ru.novotech.ThinkYou.resultsOfPsychologicalTests.service.UserResultsService;
import ru.novotech.ThinkYou.validation.annotation.group.ForUpdate;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/results")
public class userResultsController {
    private final UserResultsService userResultsService;

    @PostMapping("/{userId}")
    public UserResultsResponseDto addUserResults(@RequestBody @Validated UserResultsRequestDto userResultsRequestDto,
                                                 @PathVariable Long userId) {
        log.info("Запрос на добавление результатов тестов пользователя");
        return userResultsService.addUserResults(userResultsRequestDto, userId);
    }

    @PatchMapping("/{userId}/{userResultsId}")
    public UserResultsResponseDto updateUserResults(@RequestBody @Validated(ForUpdate.class) UserResultsRequestDto userResultsRequestDto,
                                                    @PathVariable Long userId,
                                                    @PathVariable Long userResultsId) {
        log.info("Запрос на изменение результатов тестов пользователя");
        return userResultsService.updateUserResults(userResultsRequestDto, userId, userResultsId);
    }

    @GetMapping("/{userId}/{userResultsId}")
    public UserResultsResponseDto getUserResultsById(@PathVariable Long userId,
                                                     @PathVariable Long userResultsId) {
        log.info("Запрос на получение результатов тестов пользователя по id = {}", userId);
        return userResultsService.getUserResultsById(userId, userResultsId);
    }

    @DeleteMapping("/{userId}/{userResultsId}")
    public void deleteUserResultsById(@PathVariable Long userId,
                                      @PathVariable Long userResultsId) {
        log.info("Удаление результатов тестов пользователя по id = {}", userId);
        userResultsService.deleteUserResultsById(userId, userResultsId);
    }

    @GetMapping
    public List<UserResultsResponseDto> getAllUsersResults() {
        log.info("Запрос на получение всех результатов тестов пользователей");
        return userResultsService.getUsersResults();
    }

    @GetMapping("description/{userId}/{userResultsId}")
    public UserResultsDescriptionResponseDto getUserResultsDescription(@PathVariable Long userId,
                                                                       @PathVariable Long userResultsId) {
        log.info("Запрос на получение описания результатов когнитивного теста");
        return userResultsService.getUsersResultsDescription(userId, userResultsId);
    }
}

