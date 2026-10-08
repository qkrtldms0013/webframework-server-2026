package com.example.webframework.user;

import com.example.webframework.user.dto.LoginRequest;
import com.example.webframework.user.dto.LoginResponse;
import com.example.webframework.user.dto.SignUpRequest;
import com.example.webframework.user.dto.SignUpResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-account")
@RequiredArgsConstructor
public class UserAccountController {
    private final UserAccountService userAccountService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request
    ){
        LoginResponse response = userAccountService.login(request);

        return ResponseEntity.ok()
                .header("Cache-Control", "no-store")
                .body(response);
    }

    @PostMapping("/signup")
    public SignUpResponse signUp(@Valid @RequestBody SignUpRequest request){
        return userAccountService.signUp(request);
    }

    @GetMapping("/check-email")
    public boolean checkEmail(@RequestParam String email) {
        return userAccountService.checkEmail(email);
    }
    @GetMapping("/add")
    public String addUserAccount(String email, String password, String nickname) {
        return userAccountService.addUserAccount(email, password, nickname);
    }

    @GetMapping("/find-by-email")
    public String findUserAccountByEmail(String email){
        return userAccountService.getUserAccountByEmail(email);
    }
    @GetMapping("/update")
    public String updateUserAccount(String email, String password, String nickname){
        return userAccountService.updateUserAccount(email, password, nickname);
    }
    @GetMapping("/delete")
    public String deleteUserAccount(String email){
        return userAccountService.deleteUserAccount(email);
    }
}
