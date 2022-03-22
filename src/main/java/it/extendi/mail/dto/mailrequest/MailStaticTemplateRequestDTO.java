package it.extendi.mail.dto.mailrequest;

import com.sendgrid.Response;
import com.sendgrid.helpers.mail.Mail;
import it.extendi.mail.dto.mailresponse.MailResponseDTO;
import it.extendi.mail.dto.mailresponse.MailStaticTemplateResponseDTO;

import java.security.Principal;
import java.util.List;

public class MailStaticTemplateRequestDTO extends MailRequestDTO {
    private final String template;

    public MailStaticTemplateRequestDTO(
            List<String> receiverList,
            List<String> carbonCopyList,
            List<String> blindCarbonCopyList,
            String subject,
            String template) {
        super(receiverList, carbonCopyList, blindCarbonCopyList, subject);
        this.template = template;
    }

    @Override
    public void addContentToMail(Mail mail) {
        mail.setTemplateId(this.template);
    }

    @Override
    public MailResponseDTO mapRequestDtoToResponseDto(Response response, Principal principal) {
        return new MailStaticTemplateResponseDTO(
                principal.getName(),
                this.getReceiverList(),
                this.getCarbonCopyList(),
                this.getBlindCarbonCopyList(),
                this.getSubject(),
                response.getBody(),
                this.getTemplate()
        );
    }

    public String getTemplate() {
        return template;
    }


}
