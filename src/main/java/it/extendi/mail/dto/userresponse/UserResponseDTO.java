package it.extendi.mail.dto.userresponse;

public class UserResponseDTO {

    private final Long id;
    private final String email;
    private final String role;
    private final String apiKey;

    public UserResponseDTO(Long id, String email, String role, String apiKey) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.apiKey = apiKey;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getApiKey() {
        return apiKey;
    }
}
