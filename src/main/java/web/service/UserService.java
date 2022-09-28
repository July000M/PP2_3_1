package web.service;

import web.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> allUsers();
    void add(UserDto userDto);
    void delete(UserDto userDto);
    void edit(int id, UserDto userDto);
    UserDto getUserById(int id);
}
