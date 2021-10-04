package ru.redcollar.autoservice.model.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NonNull
    private Long userID;

    private String login;

    private String password;

    private String email;

}
