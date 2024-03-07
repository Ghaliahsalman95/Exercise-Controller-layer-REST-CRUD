package com.example.banksystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class Customer {
    private String ID,username;
    private double balance;
}
