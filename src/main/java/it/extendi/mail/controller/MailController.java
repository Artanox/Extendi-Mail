package it.extendi.mail.controller;

import it.extendi.mail.dto.mailrequest.MailRequestDTO;
import it.extendi.mail.dto.mailresponse.MailResponseDTO;
import it.extendi.mail.service.MailService;
import it.extendi.mail.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping(value = "/api/v1/mail")
    public class MailController {

    private final MailService mailService;
    public MailController(MailService mailService, UserService userService) {
        this.mailService = mailService;
    }

    @PostMapping("/send")
    public MailResponseDTO sendMailPost(
            Principal principal,
            @RequestPart("body") MailRequestDTO mailRequestDTO,
            @RequestPart(value = "files", required = false) MultipartFile[] multipartFiles) throws IOException {
        return mailService.sendMail(mailRequestDTO, multipartFiles, principal);
    }

}
