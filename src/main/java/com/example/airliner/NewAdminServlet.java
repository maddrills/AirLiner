package com.example.airliner;

import com.prepairedStatements.PrepareStatementz;
import com.prepairedStatements.PreparedStatementPutAdminData;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "NewAdminServlet", value = "/newAdmin")
public class NewAdminServlet extends HttpServlet {

    String adminName = null,adminPassword = null;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        adminName = request.getParameter("username");
        adminPassword = request.getParameter("password");

        adminName = adminName.trim();

        System.out.println(adminName+" "+adminPassword);

        PrepareStatementz preparedStatementPutAdminData = new PreparedStatementPutAdminData(adminName,adminPassword);

        try {
            preparedStatementPutAdminData.resultSet();
        } catch (SQLException e) {
            System.out.println("Exception");
            response.sendRedirect("NewAdmin.jsp");
        }
    }
}
