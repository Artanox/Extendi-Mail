package it.extendi.mail.mapper;

import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import it.extendi.mail.dto.mailrequest.MailRequestDTO;

import java.util.List;
import java.util.Optional;

public class PersonalizationMapper {

    public static Personalization mapMailRequestDtoToPersonalization(MailRequestDTO mailRequestDTO){
        Personalization personalization = new Personalization();
        addReceiverListToPersonalization(mailRequestDTO, personalization);
        addCarbonCopyListToPersonalization(mailRequestDTO, personalization);
        addBlindCarbonCopyListToPersonalization(mailRequestDTO, personalization);
        return personalization;
    }

    public static void addReceiverListToPersonalization(
            MailRequestDTO mailRequestDTO,
            Personalization personalization){
        Optional<List<String>> optionalReceiverList =
                Optional.ofNullable(mailRequestDTO.getReceiverList());
        optionalReceiverList.ifPresent(list ->
                list.forEach(email -> personalization.addTo(new Email(email))));
    }

    public static void addCarbonCopyListToPersonalization(
            MailRequestDTO mailRequestDTO,
            Personalization personalization){
        Optional<List<String>> optionalCarbonCopyList =
                Optional.ofNullable(mailRequestDTO.getCarbonCopyList());
        optionalCarbonCopyList.ifPresent(list ->
                list.forEach(email -> personalization.addCc(new Email(email))));
    }

    public static void addBlindCarbonCopyListToPersonalization(
            MailRequestDTO mailRequestDTO,
            Personalization personalization){
        Optional<List<String>> optionalBlindCarbonCopyList =
                Optional.ofNullable(mailRequestDTO.getBlindCarbonCopyList());
        optionalBlindCarbonCopyList.ifPresent(list ->
                list.forEach(email -> personalization.addBcc(new Email(email))));
    }

}
