/*
 * Copyright (C) 2010 Moduad Co., Ltd.
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package org.androidpn.server.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.androidpn.server.dao.NotificationDao;
import org.androidpn.server.model.Notification;
import org.androidpn.server.service.NotificationNotFoundException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class NotificationDaoHibernate extends HibernateDaoSupport implements NotificationDao {

	public void saveNotification(Notification notification) {

		getHibernateTemplate().saveOrUpdate(notification);
		getHibernateTemplate().flush();
	}

	public Notification getNotification(Long id) {
		Notification notification = (Notification) getHibernateTemplate().get(Notification.class, id);
		return notification;
	}

	public List<Notification> getNotificationsByUsername(String username)
			throws NotificationNotFoundException {
		List<Notification> notifications = getHibernateTemplate().find("from Notification where username=?",username);
		if (notifications == null || notifications.isEmpty()) {
			throw new NotificationNotFoundException("Notification '" + username + "' not found");
		} else {
			return notifications;
		}
	}

	public void removeNotification(Notification notification) {
		getHibernateTemplate().delete(notification);
	}


	public List<Notification> getNotificationsFromCreatedDate(Date createDate) {
		return getHibernateTemplate().find("from Notification n where n.createdDate >= ? order by n.createdDate desc",createDate);
	}

	public void removeNotificationByUUID(String uuid) {
		Notification notification = (Notification) getHibernateTemplate().find("from Notification where uuid=?",uuid);
		if (notification != null ) {
			removeNotification(notification);
		}
	}


}
