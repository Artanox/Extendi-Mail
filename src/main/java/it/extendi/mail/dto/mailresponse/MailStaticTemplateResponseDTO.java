package it.extendi.mail.dto.mailresponse;

import java.util.List;

public class MailStaticTemplateResponseDTO extends MailResponseDTO{
    private final String template;

    public MailStaticTemplateResponseDTO(
            String sender,
            List<String> receiverList,
            List<String> carbonCopyList,
            List<String> blindCarbonCopyList,
            String subject,
            String response,
            String template) {
        super(sender, receiverList, carbonCopyList, blindCarbonCopyList, subject, response);
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }
}
