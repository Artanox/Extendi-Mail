package it.extendi.mail.dto.mailresponse;

import java.util.List;

public class MailTextResponseDTO extends MailResponseDTO {
    private final String text;

    public MailTextResponseDTO(
            String sender,
            List<String> receiverList,
            List<String> carbonCopyList,
            List<String> blindCarbonCopyList,
            String subject,
            String response,
            String text) {
        super(sender, receiverList, carbonCopyList, blindCarbonCopyList, subject, response);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
