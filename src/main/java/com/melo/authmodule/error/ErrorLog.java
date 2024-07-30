package com.melo.authmodule.error;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ErrorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "error_message", columnDefinition = "TEXT")
    private String errorMessage;

    @Column(name = "stack_trace", columnDefinition = "TEXT")
    private String stackTrace;

    public ErrorLog(String message, String stackTrace) {
        this.errorMessage = message;
        this.stackTrace = stackTrace;
    }

    public ErrorLog(String message) {
        this.errorMessage = message;
    }
}

