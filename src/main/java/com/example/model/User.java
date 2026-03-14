package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {


    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    
   
}
