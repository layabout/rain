package com.mobaopay.portal.web.sample;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by ruby on 2016/5/30.
 * Email:liyufeng_23@163.com
 */
public class SigninForm {

    private static final String NOT_BLANK_MESSAGE = "{login.password.not.blank.message}";

    @Size(min = 6,max = 18)
    private String username;
    @NotBlank(message = SigninForm.NOT_BLANK_MESSAGE)
    private String password;

    public SigninForm() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
