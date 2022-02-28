package com.example.ejbtest1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    private double loanAmount;
    private double rate;
    private double tenure;
}
