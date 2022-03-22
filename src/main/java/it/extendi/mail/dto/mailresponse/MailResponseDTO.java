package it.extendi.mail.dto.mailresponse;

import java.util.List;

public abstract class MailResponseDTO {

    private final String sender;
    private final List<String> receiverList;
    private final List<String> carbonCopyList;
    private final List<String> blindCarbonCopyList;
    private final String subject;
    private final String response;

    public MailResponseDTO(
            String sender,
            List<String> receiverList,
            List<String> carbonCopyList,
            List<String> blindCarbonCopyList,
            String subject,
            String response) {
        this.sender = sender;
        this.receiverList = receiverList;
        this.carbonCopyList = carbonCopyList;
        this.blindCarbonCopyList = blindCarbonCopyList;
        this.subject = subject;
        this.response = response;
    }

    public String getSender() {
        return sender;
    }

    public List<String> getReceiverList() {
        return receiverList;
    }

    public List<String> getCarbonCopyList() {
        return carbonCopyList;
    }

    public List<String> getBlindCarbonCopyList() {
        return blindCarbonCopyList;
    }

    public String getSubject() {
        return subject;
    }

    public String getResponse() {
        return response;
    }
}
