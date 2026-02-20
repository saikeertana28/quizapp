package com.student.controller;
import com.student.dto.*;
import com.student.repository.StudentAttemptRepository;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {
    @Autowired
    StudentAttemptRepository studentAttemptRepo;
    @Autowired
    private StudentService studentService;
    @GetMapping("/quizzes-shared/{email}")
    public List<QuizDataForStudent> getQuizzesForStudent(@PathVariable String email) {
        return studentService.getQuizzesByEmail(email);
    }
    @GetMapping("questionsforquiz/{quizid}")
    public ResponseEntity<List<QuestionDisplay>> getQuestionsforQuiz(@PathVariable Integer quizid){
        return studentService.getQuestionsforQuiz(quizid);
    }
    @PostMapping("/submit")
    public ResponseEntity<String> submitQuiz(@RequestBody QuizSubmitRequest request){
        return studentService.submitQuiz(request);
    }
    @GetMapping("/getpractice")
    public ResponseEntity<List<QuestionDisplay>> getPracticeByCategory(@RequestParam String category, @RequestParam int numQ) {
        return studentService.getRandomquesByCategory(category, numQ);
    }
    @PostMapping("/submit-practice")
    public ResponseEntity<PracticeDao> submitPractice(@RequestBody PracticeSubmitRequest request) {
        return studentService.submitPractice(request);
    }
    @GetMapping("/attempts/details/{studentId}")
    public ResponseEntity<List<AttemptedQuizDto>> getAttemptedQuizDetails(@PathVariable int studentId){
        return ResponseEntity.ok(studentService.getAttemptedQuizDetails(studentId));
    }
    @PutMapping("/update-profilepic/{email}")
    public ResponseEntity<String> updateProfilePic(@PathVariable String email, @RequestParam("file") MultipartFile file){
        return studentService.updateProfilePic(email, file);
    }
    @PutMapping("/update-profile/{email}")
    public ResponseEntity<String> updateUserProfile(@PathVariable String email, @RequestBody UsersDto updatedData) {
        return studentService.updateUserProfile(email, updatedData);
    }
    @GetMapping("/hasAttempted/{studentId}/{quizId}")
    public ResponseEntity<Boolean> hasAttempted(@PathVariable int studentId, @PathVariable int quizId) {
        boolean attempted = studentAttemptRepo.existsByStudentIdAndQuizId(studentId, quizId);
        return ResponseEntity.ok(attempted);
    }
}
