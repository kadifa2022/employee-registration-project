package com.cydeo.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {//we can put calculation in thymeleaf or in class

    //validation
   // @NotNull -->Field shouldn't be null
   // @NotEmpty -->Field shouldn't be ""
   // @NotEmpty -->Field shouldn't be "      "

    //@NotBlank=is covering all of them


   // @NotBlank
   // @Size(max=12, min=2)
    
    private String firstName;
    private String lastName;

    //Thymeleaf accepts yyyy-MM-dd, but LocalData accepts mm-dd-yyyy-yyyy-dd-mm
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")//
    private LocalDate birthday;
    @NotBlank
    @Email
    private String email;
   // @NotBlank
   // @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,}")//Protection for code
    private String password;

    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;


}
