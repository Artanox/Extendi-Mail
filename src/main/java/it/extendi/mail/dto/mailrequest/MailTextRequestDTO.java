package it.extendi.mail.dto.mailrequest;

import com.sendgrid.Response;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import it.extendi.mail.dto.mailresponse.MailResponseDTO;
import it.extendi.mail.dto.mailresponse.MailTextResponseDTO;

import java.security.Principal;
import java.util.List;

public class MailTextRequestDTO extends MailRequestDTO {
    private final String text;

    public MailTextRequestDTO(
            List<String> receiverList,
            List<String> carbonCopyList,
            List<String> blindCarbonCopyList,
            String subject,
            String text) {
        super(receiverList, carbonCopyList, blindCarbonCopyList, subject);
        this.text = text;
    }

    @Override
    public void addContentToMail(Mail mail) {
        mail.addContent(new Content("text/plain", this.text));
    }

    @Override
    public MailResponseDTO mapRequestDtoToResponseDto(Response response, Principal principal) {
        return new MailTextResponseDTO(
                principal.getName(),
                this.getReceiverList(),
                this.getCarbonCopyList(),
                this.getBlindCarbonCopyList(),
                this.getSubject(),
                response.getBody(),
                this.getText()
        );
    }

    public String getText() {
        return text;
    }

}
