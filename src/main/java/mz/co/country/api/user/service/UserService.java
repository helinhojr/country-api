package mz.co.country.api.user.service;

import mz.co.country.api.user.domain.CreateUserCommand;
import mz.co.country.api.user.domain.UpdateUserCommand;
import mz.co.country.api.user.domain.User;
import mz.co.country.api.user.domain.UserStatus;
import mz.co.country.api.user.domain.query.UserQuery;
import mz.co.country.api.user.presentation.UserJson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User create(CreateUserCommand command);
    User findById(Long id);
    Page<User> fetchPaged(Pageable pageable, UserQuery userQuery);
    void deleteById(Long id);
    User update(UpdateUserCommand command, Long id);

    UserJson setStatus(Long userId, UserStatus status);

    long countAllUsers();
}
