package com.example.student.feign;

import com.example.student.dto.TeacherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static com.example.student.constant.Constant.FEIGN_URL;

@FeignClient(value = "teacher-api", url = FEIGN_URL, fallback = FeignFallBack.class)
public interface FeignService {

    @GetMapping("/name/{teacherName}")
    public ResponseEntity<TeacherDto> findTeacherByName(@PathVariable String teacherName);

    @GetMapping("/age/{age}")
    public ResponseEntity<List<TeacherDto>> findTeacherByAge(@PathVariable int age);
}
