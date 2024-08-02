package com.bookingsystem.userservice.entities;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Telephone implements Serializable {
    private String indicatif;
    private String number;
}
