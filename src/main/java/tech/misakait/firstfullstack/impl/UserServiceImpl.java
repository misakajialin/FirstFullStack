package tech.misakait.firstfullstack.impl;

import org.springframework.stereotype.Service;
import tech.misakait.firstfullstack.dto.UserDTO;
import tech.misakait.firstfullstack.service.UserService;
@Service("usi")
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(UserDTO usr) {
        if (usr.getUsername().equals("123456") && usr.getPassword().equals("123456")) {
            System.out.println("Login success");
            return true;
        } else {
            System.out.println("Login failed");
            return false;
        }

    }
}
