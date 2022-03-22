package it.extendi.mail.security;

import it.extendi.mail.dto.userrequest.UserRequestDTO;
import it.extendi.mail.dto.userresponse.UserResponseDTO;
import it.extendi.mail.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class SecurityController {

    private final UserService userService;

    public SecurityController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponseDTO registerPost(@RequestPart("user") UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);
    }


}
