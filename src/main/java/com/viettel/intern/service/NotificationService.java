package com.viettel.intern.service;

import com.viettel.intern.entity.base.Notification;
import org.springframework.data.domain.Page;


public interface NotificationService {

    /**
     * Saves the specified notification to the database
     *
     * @param notification The notification to be saved
     */
    void save(Notification notification);

    public Page<Notification> getAllNotifications(int page, int size);
}

