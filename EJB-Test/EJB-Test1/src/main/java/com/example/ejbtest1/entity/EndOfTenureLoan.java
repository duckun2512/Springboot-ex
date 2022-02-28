package com.example.ejbtest1.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EndOfTenureLoan {
    private double loanAmount;
    private double rate;
}
