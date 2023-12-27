package com.viettel.intern.controller;

import com.viettel.intern.config.factory.response.GeneralResponse;
import com.viettel.intern.config.factory.response.ResponseFactory;
import com.viettel.intern.entity.base.Notification;
import com.viettel.intern.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    private final ResponseFactory responseFactory;

    @GetMapping("")
    public ResponseEntity<GeneralResponse<Object>> getAllNotifications(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Notification> notificationPage = notificationService.getAllNotifications(page, size);
        return responseFactory.success(notificationPage);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("")
    public ResponseEntity<GeneralResponse<Object>> createNotification(@RequestBody Notification notification) {
        notificationService.save(notification);
        return responseFactory.success("Notification created successfully.");
    }
}
