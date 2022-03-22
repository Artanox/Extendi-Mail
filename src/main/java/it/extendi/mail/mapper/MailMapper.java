package it.extendi.mail.mapper;

import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import it.extendi.mail.dao.UserDAO;
import it.extendi.mail.dto.mailrequest.MailRequestDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

public class MailMapper {
    public static Mail mapMailRequestDtoToMail(MailRequestDTO mailRequestDTO, MultipartFile[] multipartFiles, UserDAO userDAO) {
        Mail mail = new Mail();
        Personalization personalization = PersonalizationMapper.mapMailRequestDtoToPersonalization(mailRequestDTO);
        mail.setFrom(new Email(userDAO.getEmail()));
        mail.setSubject(mailRequestDTO.getSubject());
        mapAttachmentsToMail(multipartFiles, mail);
        mail.addPersonalization(personalization);
        mailRequestDTO.addContentToMail(mail);
        return mail;
    }

    public static void mapAttachmentsToMail(MultipartFile[] multipartFiles, Mail mail) {
        if (multipartFiles != null && multipartFiles.length > 0)
            Arrays.stream(multipartFiles).forEach(multipartFile ->
                    mail.addAttachments(AttachmentsMapper.mapMultipartFileToAttachments(multipartFile)));
    }

}
