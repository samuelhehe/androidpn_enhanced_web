package org.androidpn.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "apn_notification")
public class Notification implements Serializable {

	private static final long serialVersionUID = 2209013519421434132L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    @Column(name = "api_key", nullable = false, length = 64)
    private String apiKey;
    @Column(name = "username", nullable = false, length = 64)
    private String username;
    @Column(name = "title", nullable = false, length = 64)
    private String title;
    @Column(name = "message", nullable = false, length = 1000)
	private String message;
    @Column(name = "uri", nullable = true,length = 256)
    private String uri;
    
    @Column(name = "uuid", nullable = false,length = 256 , unique=true)
    private String uuid;
    
    
	@Column(name = "created_date", updatable = false)
	private Date createdDate = new Date();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	

}
