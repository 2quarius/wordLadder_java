package com.sixplus.demo.Service;

import com.sixplus.demo.Entity.User;

public interface UserService {
    void insert(User user);

    /**
     * @param username
     * @return UserEntity
     */
    User getByUsername(String username);
}
