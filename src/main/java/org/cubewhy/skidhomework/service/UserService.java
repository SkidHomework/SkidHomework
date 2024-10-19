package org.cubewhy.skidhomework.service;

import org.cubewhy.skidhomework.entity.User;

public interface UserService {
    User findByUsername(String username);

    User findByEmail(String email);

    User findByUsernameOrEmail(String value);

    User register(String username, String password, String email);
}
