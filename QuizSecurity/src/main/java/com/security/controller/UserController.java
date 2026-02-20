package com.security.controller;
import com.security.dto.LoginResponse;
import com.security.model.Users;
import com.security.repository.UserRepo;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.security.service.JwtUserService;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class UserController {
    @Autowired
    private UserService userservice;
    @Autowired
    private UserRepo userRepo;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user){
        return userservice.register(user);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody Users user) {
        String token=userservice.verify(user);
        Long studentId = userRepo.findStudentIdByEmail(user.getEmail());
        String username = userRepo.findUsernameByEmail(user.getEmail());

        // 3. Build response
        LoginResponse response = new LoginResponse(token, studentId, user.getEmail(), username);

        return ResponseEntity.ok(response);
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        return ResponseEntity.ok(userservice.generateOtp(email));
    }
    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        boolean valid = userservice.verifyOtp(email, otp);
        return valid
                ? ResponseEntity.ok("OTP verified")
                : ResponseEntity.badRequest().body("Invalid or expired OTP");
    }
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String email,@RequestParam String newPassword,@RequestParam String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            return ResponseEntity.badRequest().body("Passwords do not match.");
        }
        return ResponseEntity.ok(userservice.resetPassword(email, newPassword));
    }
    @PutMapping("/update-profile-pic/{email}")
    public ResponseEntity<String> updateProfilePic(
            @PathVariable String email,
            @RequestParam("file") MultipartFile file) {
        return userservice.updateProfilePicture(email, file);
    }
    @PutMapping("/update-profile/{email}")
    public ResponseEntity<String> updateUserProfile(
            @PathVariable String email,
            @RequestBody Users updatedData) {
        return userservice.updateUserProfile(email, updatedData);
    }
}
