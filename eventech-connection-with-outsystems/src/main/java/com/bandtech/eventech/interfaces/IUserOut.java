package com.bandtech.eventech.interfaces;

import com.bandtech.eventech.model.V1.User;

public interface IUserOut {
    User getForEntity(Long userId);

    void postForEntity(User user);

    void deleteForEntity(Long userId);

    void putForEntity(Long userId,User user);
}
