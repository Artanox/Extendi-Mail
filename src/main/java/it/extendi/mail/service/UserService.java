package it.extendi.mail.service;

import it.extendi.mail.dao.UserDAO;
import it.extendi.mail.dto.userrequest.UserRequestDTO;
import it.extendi.mail.dto.userresponse.UserResponseDTO;
import it.extendi.mail.mapper.UserMapping;
import it.extendi.mail.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        userRepository.findByEmail(userRequestDTO.getEmail())
                .ifPresent(e -> {throw new IllegalArgumentException("Email already registered");});
        UserDAO userDAO = UserMapping.mapUserRequestDtoToUserDao(userRequestDTO);
        return UserMapping.mapUserDaoToUserResponseDto(saveUserDao(userDAO));
    }

    public UserDAO saveUserDao(UserDAO userDAO) {
        return userRepository.save(userDAO);
    }

    public UserDAO getUserByEmail(String name) {
        return userRepository.findByEmail(name).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
