package com.example.entitytodto.EntityToDTOConversion.dto;

import lombok.Data;

@Data
public class StudentDto {

    private Long id;
    private String name;
    private String surname;
    private Integer year;

}
