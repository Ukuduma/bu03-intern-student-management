package com.viettel.intern.dto;

import com.viettel.intern.entity.base.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Long id;
    private String name;
    private String code;
    private Integer creditCount;
    private Integer studentCount;
    private Integer maxStudentCount;
    private String classroom;
    private Long lecturerId;
    private Long departmentId;
    private Long scheduleId;
    private Boolean status;

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.code = course.getCode();
        this.creditCount = course.getCreditCount();
        this.maxStudentCount = course.getMaxStudentCount();
        this.classroom = course.getClassroom();
        this.lecturerId = course.getLecturerId();
        this.departmentId = course.getDepartmentId();
        this.scheduleId = course.getScheduleId();
        this.status = course.getStatus();
    }
}
