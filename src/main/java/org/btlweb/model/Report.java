package org.btlweb.model;

import java.util.Date;

public class Report {
	private int report_id;
	private int user_id;
	private Date create_at;
	private Date expired_at;
	
	public Report(int report_id,int user_id,Date create_at,Date expired_at) {
		this.report_id = report_id;
		this.user_id = user_id;
		this.create_at = create_at;
		this.expired_at = expired_at;
	}
	
	public int getReportId() {
		return report_id;
	}
	
	public void setReportId(int report_id) {
		this.report_id = report_id;
	}
	
	public int getUserId() {
		return user_id;
	}
	
	public void setUserId(int user_id) {
		this.user_id = user_id;
	}
	
	public Date getCreateAt() {
		return create_at;
	}
	
	public void setCreateAt(Date create_at) {
		this.create_at = create_at;
	}
	
	public Date getExpiredAt() {
		return expired_at;
	}
	
	public void setExpiredAt(Date expired_at) {
		this.expired_at = expired_at;
	}
}
