package org.btlweb.controller;

import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btlweb.dao.ChartDAO;

public class ChartController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ChartDAO chartDAO = new ChartDAO();
        List<String> labels = chartDAO.getLabels();
        List<Integer> data = chartDAO.getData();
        List<String> uniqueLabels = new ArrayList<>();
        List<Integer> aggregatedData = new ArrayList<>();
        
        for (int i = 0; i < labels.size(); i++) {
            String label = labels.get(i);
            System.out.println(label);
            int count = data.get(i);
            System.out.println(count);

            if (!uniqueLabels.contains(label)) {
                uniqueLabels.add(label);
                aggregatedData.add(count);
            } else {
                int index = uniqueLabels.indexOf(label);
                int aggregatedCount = aggregatedData.get(index) + count;
                aggregatedData.set(index, aggregatedCount);
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < uniqueLabels.size(); i++) {
            sb.append("{\"label\":\"").append(uniqueLabels.get(i)).append("\",\"data\":").append(aggregatedData.get(i)).append("}");
            if (i < uniqueLabels.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        String jsonData = sb.toString();

        System.out.println(sb);
        response.setContentType("application/json");
        response.getWriter().write(jsonData);
    }
}
