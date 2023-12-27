package com.viettel.intern.service;

import com.viettel.intern.dto.CourseDTO;
import org.springframework.data.domain.Page;

public interface AdminService {
    Page<CourseDTO> searchAndSortCourses(String keyword, int page, int size, String sortBy, String sortOrder);
}
