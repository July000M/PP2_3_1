package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.dao.UserDAOImpl;
import web.dto.UserDto;
import web.model.User;
import web.utils.UserMapper;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final UserMapper userMapper;

    public UserServiceImpl(UserDAO userDAO, UserMapper userMapper) {
        this.userDAO = userDAO;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> allUsers() {
        return userDAO.allUsers().stream()
                .map(userMapper::mapToUserDto)
                .toList();
    }

    @Override
    public void add(UserDto userDto) {
        User user = userMapper.mapToUserEntity(userDto);
        userDAO.add(user);
    }

    @Override
    public void delete(UserDto userDto) {
        User user = userMapper.mapToUserEntity(userDto);
        userDAO.delete(user);
    }

    @Override
    public void edit(int id, UserDto userDto) {
        User user = userMapper.mapToUserEntity(userDto);
        userDAO.edit(id, user);
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userDAO.getUserById(id);
        return userMapper.mapToUserDto(user);
    }
}
