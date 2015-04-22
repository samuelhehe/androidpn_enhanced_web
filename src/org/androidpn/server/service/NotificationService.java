package org.androidpn.server.service;

import java.util.Date;
import java.util.List;

import org.androidpn.server.model.Notification;
import org.androidpn.server.service.NotificationNotFoundException;

public interface NotificationService {

	public void saveNotification(Notification notification);

	public Notification getNotification(Long id);

	public List<Notification> getNotificationsByUsername(String username)	throws NotificationNotFoundException;

	public void removeNotification(Notification notification);

	public List<Notification> getNotificationsFromCreatedDate(Date createDate);
	
	public void removeNotificationByUUID(String uuid);

}
