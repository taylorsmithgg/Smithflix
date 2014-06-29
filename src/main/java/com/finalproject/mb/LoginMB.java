package com.finalproject.mb;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.naming.AuthenticationException;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginMB {
    private String userName = null;
    private String password = null;

    @ManagedProperty(value = "#{authenticationManager")
    private AuthenticationManager authenticationManager = null;

    public String doLogin() {
        System.out.println(this.getUserName());
        System.out.println(this.getPassword());
        Authentication request = new UsernamePasswordAuthenticationToken(this.getUserName(), this.getPassword());
        Authentication response = authenticationManager.authenticate(request);
        SecurityContextHolder.getContext().setAuthentication(response);
        return "correct";
    }

    public String cancel() {
        return null;
    }

    public String logout() {
        SecurityContextHolder.clearContext();
        return "logged out";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
}
