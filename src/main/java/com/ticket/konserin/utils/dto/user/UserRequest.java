package com.ticket.konserin.utils.dto.user;

import com.ticket.konserin.model.Role;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private Role roles;
}
