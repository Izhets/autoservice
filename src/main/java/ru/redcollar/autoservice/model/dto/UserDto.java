package ru.redcollar.autoservice.model.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NonNull
    private Long id;
    private String login;
    private String password;
    private String email;

}
