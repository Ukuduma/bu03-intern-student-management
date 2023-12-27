package com.viettel.intern.controller;

import com.viettel.intern.config.factory.response.GeneralResponse;
import com.viettel.intern.config.factory.response.ResponseFactory;
import com.viettel.intern.dto.CourseDTO;
import com.viettel.intern.entity.base.Course;
import com.viettel.intern.service.CourseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/courses")
@AllArgsConstructor
public class CourseController {

    private ModelMapper modelMapper;
    private final ResponseFactory responseFactory;
    private final CourseService courseService;

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("")
    public ResponseEntity<GeneralResponse<Object>> getAllCourses() {
        return responseFactory.success(courseService.getAllCourse());
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("")
    public ResponseEntity<GeneralResponse<Object>> createCourse(@RequestBody CourseDTO courseDTO) {
        Course course = modelMapper.map(courseDTO, Course.class);
        courseService.save(course);
        return responseFactory.success(course);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse<Object>> updateCourse(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        Course existingCourse = courseService.findById(id);
        if (existingCourse == null) {
            throw new RuntimeException("Course with ID " + id + " not found.");
        }

        modelMapper.map(courseDTO, existingCourse);
        Course updatedCourse = courseService.save(existingCourse);

        return responseFactory.success(updatedCourse);
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse<Object>> removeCourse(@PathVariable Long id) {
        courseService.deleteById(id);
        return responseFactory.successNoData();
    }

    // Get thong tin chi tiet hoc phan
    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse<Object>> getCourseById(@PathVariable("id") Long id) {
        return responseFactory.success(courseService.findById(id));
    }
}
