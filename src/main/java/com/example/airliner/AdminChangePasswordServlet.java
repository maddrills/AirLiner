package com.example.airliner;

import com.prepairedStatements.PrepareStatementz;
import com.prepairedStatements.PreparedStatmentChangeAdminPass;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminChangePasswordServlet",value = "/changeAdminPass")
public class AdminChangePasswordServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String adminId = request.getParameter("adminId");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        System.out.println(adminId+" "+password+" "+confirmPassword);

        if(adminId == null || password == null || confirmPassword == null){

            System.out.println("Error encountered");

        }
        else {

            if(password.equals(confirmPassword)){

                System.out.println("password match");

                PrepareStatementz PreparedStatmentChangeAdminPass = new PreparedStatmentChangeAdminPass(password,adminId);

                try {

                    PreparedStatmentChangeAdminPass.resultSet();

                } catch (SQLException e) {

                    System.out.println("Error");

                }

                response.sendRedirect("AdminLogin.jsp");

            }
            else {

                System.out.println("Try again");

                response.sendRedirect("adminChangePass.jsp");

            }
        }
    }
}
