package com.nielo.springsecuritybasicauth.springsecuritybasicauth.exception;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String details;
}
