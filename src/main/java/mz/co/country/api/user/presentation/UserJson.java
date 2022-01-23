package mz.co.country.api.user.presentation;

import lombok.Getter;
import lombok.Setter;
import mz.co.country.api.user.domain.UserRole;
import mz.co.country.api.user.domain.UserStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserJson {
    private Long id;
    private String name;
    private String email;
    private String username;
    private UserStatus userStatus;
    private UserRole role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
