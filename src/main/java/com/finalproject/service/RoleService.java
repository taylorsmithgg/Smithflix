package com.finalproject.service;

import com.finalproject.dao.RoleDAO;
import com.finalproject.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleDAO roleDAO;

    public Role getRole(int id) {
        return roleDAO.getRole(id);
    }
}
