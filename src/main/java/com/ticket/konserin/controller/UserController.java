package com.ticket.konserin.controller;

import com.ticket.konserin.service.UserService;
import com.ticket.konserin.utils.dto.user.UserRequest;
import com.ticket.konserin.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserRequest request){
        return Response.renderJSON(
                userService.create(request),"user created",
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return Response.renderJSON(userService.getById(id));
    }
}
