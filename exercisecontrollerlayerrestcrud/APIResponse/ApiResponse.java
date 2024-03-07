package com.example.exercisecontrollerlayerrestcrud.APIResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

@Data@AllArgsConstructor
public class ApiResponse {
    private String response;
}
