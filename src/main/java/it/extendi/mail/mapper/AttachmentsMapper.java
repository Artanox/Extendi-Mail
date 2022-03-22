package it.extendi.mail.mapper;

import com.sendgrid.helpers.mail.objects.Attachments;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public class AttachmentsMapper {

    public static Attachments mapMultipartFileToAttachments(MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        InputStream inputStream = null;
        try {inputStream = multipartFile.getInputStream();}
        catch (IOException e) {e.printStackTrace();}
        return new Attachments
                .Builder(originalFilename, inputStream)
                .build();
    }

}
