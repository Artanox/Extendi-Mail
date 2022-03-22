package it.extendi.mail.dto.mailrequest;

import com.sendgrid.Response;
import com.sendgrid.helpers.mail.Mail;
import it.extendi.mail.dto.mailresponse.MailDynamicTemplateNameDayResponseDTO;
import it.extendi.mail.dto.mailresponse.MailResponseDTO;

import java.security.Principal;
import java.util.List;

public class MailDynamicTemplateNameDayRequestDTO extends MailRequestDTO {
    private final String template;
    private final String name;
    private final String day;

    public MailDynamicTemplateNameDayRequestDTO(
            List<String> receiverList,
            List<String> carbonCopyList,
            List<String> blindCarbonCopyList,
            String subject,
            String template,
            String name,
            String day) {
        super(receiverList, carbonCopyList, blindCarbonCopyList, subject);
        this.template = template;
        this.name = name;
        this.day = day;
    }

    @Override
    public void addContentToMail(Mail mail) {
        mail.setTemplateId(this.template);
        mail.getPersonalization().forEach(personalization -> {
            personalization.addDynamicTemplateData("name", this.name);
            personalization.addDynamicTemplateData("day", this.day);
        });
    }

    @Override
    public MailResponseDTO mapRequestDtoToResponseDto(Response response, Principal principal) {
        return new MailDynamicTemplateNameDayResponseDTO(
                principal.getName(),
                this.getReceiverList(),
                this.getCarbonCopyList(),
                this.getBlindCarbonCopyList(),
                this.getSubject(),
                response.getBody(),
                this.getTemplate(),
                this.getName(),
                this.getDay()
        );
    }

    public String getTemplate() {
        return template;
    }

    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }
}
