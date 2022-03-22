package it.extendi.mail.service;

import com.sendgrid.Response;
import com.sendgrid.helpers.mail.Mail;
import it.extendi.mail.dao.UserDAO;
import it.extendi.mail.dto.mailrequest.MailRequestDTO;
import it.extendi.mail.dto.mailresponse.MailResponseDTO;
import it.extendi.mail.mapper.MailMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Service
public class MailService {

    private final RequestService requestService;
    private final UserService userService;
    public MailService(RequestService requestService, UserService userService) {
        this.requestService = requestService;
        this.userService = userService;
    }

    public MailResponseDTO sendMail(
            MailRequestDTO mailRequestDTO,
            MultipartFile[] multipartFiles,
            Principal principal) throws IOException {
        UserDAO userDAO = userService.getUserByEmail(principal.getName());
        Mail mail = MailMapper.mapMailRequestDtoToMail(mailRequestDTO, multipartFiles, userDAO);
        Response response = requestService.sendRequest(mail, userDAO);
        return mailRequestDTO.mapRequestDtoToResponseDto(response, principal);
    }

}

