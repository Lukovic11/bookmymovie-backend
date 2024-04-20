package com.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
}
