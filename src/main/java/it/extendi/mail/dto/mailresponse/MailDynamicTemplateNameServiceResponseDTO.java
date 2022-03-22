package it.extendi.mail.dto.mailresponse;

import java.util.List;

public class MailDynamicTemplateNameServiceResponseDTO extends MailResponseDTO{
    private final String template;
    private final String name;
    private final String service;


    public MailDynamicTemplateNameServiceResponseDTO(
            String sender,
            List<String> receiverList,
            List<String> carbonCopyList,
            List<String> blindCarbonCopyList,
            String subject,
            String response,
            String template,
            String name,
            String service) {
        super(sender, receiverList, carbonCopyList, blindCarbonCopyList, subject, response);
        this.template = template;
        this.name = name;
        this.service = service;
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
