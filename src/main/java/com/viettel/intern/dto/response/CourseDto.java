package com.viettel.intern.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private Long id;

    private String name;

    private Integer creditCount;

    private Date startDate;

    private Date endDate;

    private Boolean status;

    private String classroom;

    private Long lecturerId;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "DEPARTMENT_ID")
//    private Department department;
//    @ManyToMany
//    @JoinTable(name = "ENROLMENT")
//    private List<Student> students;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn("LECTURER_ID")
//    private Lecturer lecturer;
}




