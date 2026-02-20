package com.security.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private String role;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dob;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] profilePic;

    public int getId() {
        return id;
    }
    public void setId(int id) {this.id=id;}
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public LocalDate getDob() {
        return dob;
    }
    public byte[] getProfilePic() {
        return profilePic;
    }
    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

}
