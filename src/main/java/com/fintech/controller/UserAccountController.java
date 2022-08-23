package com.fintech.controller;

import com.fintech.entity.UserAccountEntity;
import com.fintech.mapper.UserMapper;
import com.fintech.response.UserResponse;
import com.fintech.resquest.UserRequest;
import com.fintech.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/fintech")
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;
    private final UserMapper userMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse post(@Valid @RequestBody UserRequest userRequest){
        UserAccountEntity entity = userAccountService.addUser(userMapper.toEntity(userRequest));
        return userMapper.toResponse(entity);
    }

    @GetMapping("/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getCpf(@PathVariable Long cpf){
        UserAccountEntity entity = userAccountService.getByCpf(cpf);
        return userMapper.toResponse(entity);
    }


}
