package com.viettel.intern.repository.base;

import com.viettel.intern.dto.CourseDTO;
import com.viettel.intern.entity.base.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<CourseDTO> findByNameContainingIgnoreCase(String keyword, Pageable pageable);

    Page<CourseDTO> searchCoursesByNameContaining(String keyword, Pageable pageable);
}
