package com.melo.authmodule.user;

import com.melo.authmodule.output.UserOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PatchMapping
    public ResponseEntity<?> changePassword(
          @RequestBody ChangePasswordRequest request,
          Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UserOutput>>getConnectedUsers() {
        List<UserOutput> userOutputs = UserOutput.from(service.getConnectedUsers());
        return ResponseEntity.ok(userOutputs);
    }

    @GetMapping("/by-company/{companyCode}")
    public ResponseEntity<List<UserOutput>> getUsersByCompany(@PathVariable UUID companyCode) {
        List<User> users = service.getUsersByCompanyCode(companyCode);
        List<UserOutput> userOutputs = users.stream()
                .map(UserOutput::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userOutputs);
    }
}
