package com.security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
@Entity
public class PasswordResetOtp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String otp;
    private LocalDateTime expiryTime;
    private boolean used;

    public PasswordResetOtp() {}

    public PasswordResetOtp(String email, String otp, LocalDateTime expiryTime) {
        this.email = email;
        this.otp = otp;
        this.expiryTime = expiryTime;
        this.used = false;
    }
public void setEmail(String email) {
        this.email = email;
}
public void setOtp(String otp) {
        this.otp = otp;
}
public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
}
public void setUsed(boolean used) {
        this.used = used;

}
public Long getId() {
        return id;
}
public void setId(Long id) {
        this.id = id;
}
public String getEmail() {
        return email;
}
public LocalDateTime getExpiryTime() {
        return expiryTime;
}
}