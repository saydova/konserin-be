package com.ticket.konserin.service;

import com.ticket.konserin.model.User;
import com.ticket.konserin.utils.dto.user.UserRequest;

public interface UserService {
    User create (UserRequest request);
    User getById (Integer id);
    User udpdateById (Integer id, UserRequest request);
    void deleteById (Integer id);
}
