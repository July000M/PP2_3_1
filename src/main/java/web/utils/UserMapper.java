package web.utils;

import org.springframework.stereotype.Component;
import web.dto.UserDto;
import web.model.User;

@Component
public class UserMapper {

    public UserDto mapToUserDto(User userEntity) {
        UserDto dto = new UserDto();
        dto.setId(userEntity.getId());
        dto.setName(userEntity.getName());
        dto.setSurname(userEntity.getSurname());
        return dto;
    }

    public User mapToUserEntity(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        return user;
    }
}


