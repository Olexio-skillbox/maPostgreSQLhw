package org.example.namesdb.user.dto.response;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.example.namesdb.user.entity.UserEntity;

@Getter
@SuperBuilder
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;

    public static UserResponse of(UserEntity item) {
        return UserResponse.builder()
                .id(item.getId())
                .firstName(item.getFirstName())
                .lastName(item.getLastName())
                .build();
    }
}
