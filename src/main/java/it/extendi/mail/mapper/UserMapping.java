package it.extendi.mail.mapper;

import it.extendi.mail.dao.RoleDAO;
import it.extendi.mail.dao.UserDAO;
import it.extendi.mail.dto.userrequest.UserRequestDTO;
import it.extendi.mail.dto.userresponse.UserResponseDTO;

public class UserMapping {

    public static UserResponseDTO mapUserDaoToUserResponseDto(UserDAO userDAO){
        return new UserResponseDTO(userDAO.getId(), userDAO.getEmail(), userDAO.getRole().getName(), userDAO.getApiKey());
    }

    public static UserDAO mapUserRequestDtoToUserDao(UserRequestDTO userRequestDTO){
        return new UserDAO(userRequestDTO.getEmail(), userRequestDTO.getPassword(), new RoleDAO("user"), userRequestDTO.getApiKey());
    }
}
