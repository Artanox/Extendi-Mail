package it.extendi.mail.dto.mailrequest;

import com.sendgrid.Response;
import com.sendgrid.helpers.mail.Mail;
import it.extendi.mail.dto.mailresponse.MailDynamicTemplateNameServiceResponseDTO;
import it.extendi.mail.dto.mailresponse.MailResponseDTO;

import java.security.Principal;
import java.util.List;

public class MailDynamicTemplateNameServiceRequestDTO extends MailRequestDTO {
    private final String template;
    private final String name;
    private final String service;

    public MailDynamicTemplateNameServiceRequestDTO(
            List<String> receiverList,
            List<String> carbonCopyList,
            List<String> blindCarbonCopyList,
            String subject,
            String template,
            String name,
            String service) {
        super(receiverList, carbonCopyList, blindCarbonCopyList, subject);
        this.template = template;
        this.name = name;
        this.service = service;
    }

    @Override
    public void addContentToMail(Mail mail) {
        mail.setTemplateId(this.template);
        mail.getPersonalization().forEach(personalization -> {
            personalization.addDynamicTemplateData("name", this.name);
            personalization.addDynamicTemplateData("service", this.service);
        });
    }

    @Override
    public MailResponseDTO mapRequestDtoToResponseDto(Response response, Principal principal) {
        return new MailDynamicTemplateNameServiceResponseDTO(
                principal.getName(),
                this.getReceiverList(),
                this.getCarbonCopyList(),
                this.getBlindCarbonCopyList(),
                this.getSubject(),
                response.getBody(),
                this.getTemplate(),
                this.getName(),
                this.getService()
        );
    }

    public String getTemplate() {
        return template;
    }

    public String getName() {
        return name;
    }

    public String getService() {
        return service;
    }
}
