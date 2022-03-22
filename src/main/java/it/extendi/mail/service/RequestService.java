package it.extendi.mail.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import it.extendi.mail.dao.UserDAO;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RequestService {

    public Response sendRequest(Mail mail, UserDAO userDAO) throws IOException {
        SendGrid sendGrid = new SendGrid(userDAO.getApiKey());
        Request request = buildRequest(mail.build());
        return sendGrid.api(request);
    }

    public Request buildRequest(String buildMail){
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(buildMail);
        return request;
    }

}
