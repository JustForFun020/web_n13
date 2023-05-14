package org.btlweb.dao;

import java.util.List;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.btlweb.model.Report;
import org.btlweb.model.UserAccounts;
import org.btlweb.jdbc.JDBCUnit;

public class ReportDAO {
	Connection c = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Report> getAllReports() {
		List<Report> reports = new ArrayList<>();
		String query = "select * from [WEB].[dbo].[baoCao]";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				reports.add(new Report(
						rs.getInt(1), 
						rs.getInt(2), 
						rs.getDate(3), 
						rs.getDate(4)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return reports;
	}
	public static void main(String[] args) {
		ReportDAO reportDAO= new ReportDAO(); 
		List<Report> reports = reportDAO.getAllReports();
		for(Report o : reports) {
			System.out.println(o.getCreateAt());
		}
	}
}
