package com.example.airliner;

import com.prepairedStatements.PrepareStatementz;
import com.prepairedStatements.PreparedStatementGetUserPassword;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "UserLogInServlet", value = "/authenticate")
public class UserLogInServlet extends HttpServlet {
    HttpSession session;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String dbUsername = null, dbPassword = null;



        int dbUserId = 0;

        ResultSet resultSet = null;

        username = username.trim();

        System.out.println(username + " " + password);

        PrepareStatementz preparedStatementGetUserPassword = new PreparedStatementGetUserPassword(username);

        try {
            resultSet = preparedStatementGetUserPassword.resultSet();
        } catch (SQLException e) {
            System.out.println("Error");
        }


        try {
            while (resultSet.next()) {
                dbUserId = Integer.parseInt(resultSet.getString("users_id"));
                dbUsername = resultSet.getString("user_name");
                dbPassword = resultSet.getString("user_pass");
            }
        } catch (Exception e) {
            System.out.println("Invalid Username");
        }

        System.out.println(dbUsername + " " + dbPassword+" "+dbUserId);



        //credentials check
        if (username != null && password != null) {

            if (dbUsername != null) {

                System.out.println("welcome and authenticate");

                if (dbPassword.equals(password)) {

                    System.out.println("password correct");
                    //puts the user id in session
                    session = request.getSession();
                    session.setAttribute("users_id",dbUserId);
                    //remember to redirect
                    response.sendRedirect(request.getContextPath()+"/");

                }else {

                    System.out.println("password Wrong");
                    response.sendRedirect("loginUserAdmin.jsp");

                }
            } else {

                System.out.println("Invalid Username");
                response.sendRedirect("loginUserAdmin.jsp");

            }
        }else{

            System.out.println("invalid input");
            response.sendRedirect("loginUserAdmin.jsp");

        }
    }
}
