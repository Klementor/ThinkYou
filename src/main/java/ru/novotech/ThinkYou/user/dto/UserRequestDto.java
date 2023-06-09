package ru.novotech.ThinkYou.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.novotech.ThinkYou.validation.annotation.group.ForCreate;
import ru.novotech.ThinkYou.validation.annotation.group.ForUpdate;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    @NotNull(groups = {ForCreate.class})
    private String name;

    @NotNull(groups = {ForCreate.class})
    @Email(groups = {ForCreate.class, ForUpdate.class})
    private String email;
}
