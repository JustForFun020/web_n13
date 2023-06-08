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
	
	public List<Report> totalMinuteFocus() {
		List<Report> total = new ArrayList<>();
		String query = "SELECT TOP 20 u.fullname, ISNULL(SUM(DATEDIFF(MINUTE, tl.createAt, tl.endAt)), 0) AS totalFocus, u.image FROM [BTLWEB].[dbo].[Users] u LEFT JOIN [BTLWEB].[dbo].[TodoList] tl ON u.id = tl.userID  where tl.status = 'Done' GROUP BY u.fullname, u.id, u.image ORDER BY totalFocus DESC";
		try {
			c = new JDBCUnit().getConnection();
			ps = c.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				total.add(new Report(
							rs.getString(1),
							rs.getInt(2),
							rs.getString(3)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return total;
	}
	public static void main(String[] args) {
		ReportDAO reportDAO= new ReportDAO(); 
		List<Report> reports = reportDAO.totalMinuteFocus();
		for(Report o : reports) {
			System.out.println(o.getImage());
		}
	}
}
