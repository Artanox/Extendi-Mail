package it.extendi.mail.dto.mailresponse;

import java.util.List;

public class MailDynamicTemplateNameDayResponseDTO extends MailResponseDTO{
    private final String template;
    private final String name;
    private final String day;

    public MailDynamicTemplateNameDayResponseDTO(
            String sender,
            List<String> receiverList,
            List<String> carbonCopyList,
            List<String> blindCarbonCopyList,
            String subject,
            String response,
            String template,
            String name,
            String day) {
        super(sender, receiverList, carbonCopyList, blindCarbonCopyList, subject, response);
        this.template = template;
        this.name = name;
        this.day = day;
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
