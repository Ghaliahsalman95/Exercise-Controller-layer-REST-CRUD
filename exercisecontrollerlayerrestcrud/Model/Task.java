package com.example.exercisecontrollerlayerrestcrud.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data@AllArgsConstructor
public class Task {
    //: ID , title , description , status
    private String ID , title , description,status;
}
