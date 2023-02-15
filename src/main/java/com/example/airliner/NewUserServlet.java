package com.example.airliner;

import com.prepairedStatements.PrepareStatementz;
import com.prepairedStatements.PreparedStatementPutUserData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "NewUserServlet", value = "/newUser")
public class NewUserServlet extends HttpServlet {

    public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {

        boolean excp = true;
        String userName = request.getParameter("username");
        String userPassword = request.getParameter("password");

        userName = userName.trim();

        System.out.println("user name "+userName+" "+"password "+userPassword);

        PrepareStatementz putUserDataIntoDatabase = new PreparedStatementPutUserData(userName,userPassword);

        try{
            putUserDataIntoDatabase.resultSet();
        }catch (Exception e){
            System.out.println("Exception");
            PrintWriter printWriter = response.getWriter();
            printWriter.println("Username '"+userName+"' Taken");
            excp = false;
            request.setAttribute("status",excp);
            request.getRequestDispatcher("UserSignUp.jsp").forward(request,response);

        }finally {
            System.out.println("done with user insertion");
        }

        if(excp){
            response.sendRedirect("index.jsp");
        }
    }
}
