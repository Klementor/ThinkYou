package ru.novotech.ThinkYou.user.service;



import ru.novotech.ThinkYou.user.dto.UserRequestDto;
import ru.novotech.ThinkYou.user.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto addUser(UserRequestDto userRequestDto);

    UserResponseDto updateUser(UserRequestDto userRequestDto, Long userId);

    UserResponseDto getUserById(Long userId);

    void deleteUserById(Long userId);

    List<UserResponseDto> getUsers();

}
