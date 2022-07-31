package com.example.student.feign;

import com.example.student.dto.ErrorDto;
import com.example.student.dto.TeacherDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeignFallBack implements FeignService{
    @Override
    public ResponseEntity<TeacherDto> findTeacherByName(String teacherName) {
        ErrorDto error = new ErrorDto("custom error", "message for error");
        List<ErrorDto> errorDtoList = new ArrayList<>();
        errorDtoList.add(error);
        TeacherDto teacherDto = new TeacherDto(0, null, 0, null, null, errorDtoList);
        return new ResponseEntity<TeacherDto>(teacherDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TeacherDto>> findTeacherByAge(int age) {
        return null;
    }
}
