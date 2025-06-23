package com.kariioke.E_commerce.service.interf;

import com.kariioke.E_commerce.dto.Response;
import com.kariioke.E_commerce.dto.UserDto;
import com.kariioke.E_commerce.entity.User;

public interface UserService {

    Response registerUser(UserDto registrationRequest);

    Response loginUser(UserDto loginRequest);

    Response getAllUsers();

    User getLoginUser();

    Response getUserInfoAndOrderHistory();


}
