package it.extendi.mail.dto.userrequest;

public class UserRequestDTO {

    private final String email;
    private final String password;
    private final String apiKey;

    public UserRequestDTO(String email, String password, String apiKey) {
        this.email = email;
        this.password = password;
        this.apiKey = apiKey;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getApiKey() {
        return apiKey;
    }
}
