package com.security.dto;

public class LoginResponse {
    private String token;
    private Long studentId;
    private String email;
    private String name;
    public LoginResponse(String token,Long studentId,String email,String name) {
        this.token=token;
        this.studentId=studentId;
        this.email=email;
        this.name=name;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getToken() {
        return token;
    }
    public Long getStudentId() {
        return studentId;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }

}
