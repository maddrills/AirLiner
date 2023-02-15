package com.example.airliner;

import com.prepairedStatements.PrepareStatementz;
import com.prepairedStatements.PreparedStatementGetAdminPassword;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "AdminLoginServlet", value = "/authenticateAdmin")
public class AdminLoginServlet extends HttpServlet {

    String adminName, adminPassword;
    ResultSet resultSet;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String dbAdminName = null,dbAdminPassword = null,dbAdminId = null,errorMessage = null;

        adminName = request.getParameter("username");
        adminPassword = request.getParameter("password");

        adminName = adminName.trim();
        HttpSession session = request.getSession();

        System.out.println(adminName +" "+ adminPassword);

        PrepareStatementz preparedStatementGetAdminPassword = new PreparedStatementGetAdminPassword(adminName);

        try {
            resultSet = preparedStatementGetAdminPassword.resultSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try{
            while(resultSet.next()){
                dbAdminId = resultSet.getString("admin_id");
                dbAdminName = resultSet.getString("admin_name");
                dbAdminPassword = resultSet.getString("admin_pass");
                break;
            }
        }catch (Exception e){
            System.out.println("Exception");
        }

        System.out.println(dbAdminId+" "+dbAdminName+" "+dbAdminPassword);


        if(adminName != null || adminPassword != null){

            if(dbAdminName != null){
                //match with username found

                if(dbAdminPassword.equals(adminPassword)){

                    System.out.println("Password Matched");

                    session.setAttribute("Admin_id",dbAdminId);

                    response.sendRedirect("adminAddFlightView.jsp");

                }else{

                    System.out.println("Access denied");

                    errorMessage = "Access denied";

                    request.setAttribute("Error",errorMessage);

                }
            }else{

                System.out.println("No match found");

                errorMessage = "No Admin match found";

                request.setAttribute("Error",errorMessage);

            }
        }else {

            System.out.println("Null Values");

            errorMessage = "Null Values";

            request.setAttribute("Error",errorMessage);

        }
        if(!response.isCommitted()) {

            request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
        }
    }
}
