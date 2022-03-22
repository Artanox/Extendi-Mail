package it.extendi.mail.dto.mailrequest;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.sendgrid.Response;
import com.sendgrid.helpers.mail.Mail;
import it.extendi.mail.dto.mailresponse.MailResponseDTO;

import java.security.Principal;
import java.util.List;

@JsonTypeInfo(use = Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MailTextRequestDTO.class, name = "text"),
        @JsonSubTypes.Type(value = MailStaticTemplateRequestDTO.class, name = "template"),
        @JsonSubTypes.Type(value = MailDynamicTemplateNameDayRequestDTO.class, name = "dynamicNameDay"),
        @JsonSubTypes.Type(value = MailDynamicTemplateNameServiceRequestDTO.class, name = "dynamicNameService")
})
public abstract class MailRequestDTO {

    private final List<String> receiverList;
    private final List<String> carbonCopyList;
    private final List<String> blindCarbonCopyList;
    private final String subject;

    public MailRequestDTO(
            List<String> receiverList,
            List<String> carbonCopyList,
            List<String> blindCarbonCopyList,
            String subject) {
        this.receiverList = receiverList;
        this.carbonCopyList = carbonCopyList;
        this.blindCarbonCopyList = blindCarbonCopyList;
        this.subject = subject;
    }

    public abstract void addContentToMail(Mail mail);
    public abstract MailResponseDTO mapRequestDtoToResponseDto(Response response, Principal principal);

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
}
