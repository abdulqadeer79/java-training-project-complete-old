package com.example.student.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.student.constant.Constant.ID_NOT_NULL_ERROR_MESSAGE;
import static com.example.student.constant.Constant.NAME_NOT_EMPTY_ERROR_MESSAGE;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = NAME_NOT_EMPTY_ERROR_MESSAGE)
    private String name;
    @Max(65)
    @Min(18)
    private int age;
    @Column(unique = true, name = "rollNo")
    private int rollNo;
    @Size(min = 4, max = 50)
    private String hobby;
    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd:MM:yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Min(0)
    private int teacherId;
    private List<ErrorDto> errors = new ArrayList<>();
}
