package com.company.project.interfaces;

import com.company.project.dto.RegistrationDto;
import com.company.project.model.User;
import com.company.project.response.CommonResponse;
import com.company.project.response.object.Token;

public interface UserService {
    public CommonResponse registration(RegistrationDto user) throws Exception;
    
    public Token httpBasicToken(RegistrationDto user);
    
    public String encondePassword(String password);
    
    public User guardarUser(User user);
    
    
}
