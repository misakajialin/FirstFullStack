package tech.misakait.firstfullstack.service;

import tech.misakait.firstfullstack.dto.UserDTO;

public interface UserService {
    boolean login(UserDTO usr);
}
