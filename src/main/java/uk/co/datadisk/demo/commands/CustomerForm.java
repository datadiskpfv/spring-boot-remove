package uk.co.datadisk.demo.commands;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Getter
@Setter
public class CustomerForm {
    private Integer userId;
    private Integer userVersion;
    private Integer customerId;
    private Integer customerVersion;

    @NotEmpty
    @Size(min=2, max=75)
    private String userName;
    private String passwordText;
    private String passwordTextConf;
    private String firstName;
    private String lastName;

    @NotEmpty
    @Email
    private String email;
    private String phoneNumber;
}
