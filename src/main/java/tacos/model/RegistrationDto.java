package tacos.model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationDto {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public UserDto toUser(PasswordEncoder passwordEncoder) {
        return new UserDto(
            username, passwordEncoder.encode(password), fullname, street, city, state, zip, phone);
    }
}
