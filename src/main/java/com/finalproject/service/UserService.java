package com.finalproject.service;

import com.finalproject.dao.UserDAO;
import com.finalproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserDAO userDAO;

    public User getUser(String login) {
        return userDAO.getUser(login);
    }
}
