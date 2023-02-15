package com.example.airliner;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "UserLogoutServlet", value = "/logOutUser")
public class UserLogoutServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

       String logOut =  request.getParameter("logOut");

       if(logOut != null){

           HttpSession httpSession = request.getSession();
           httpSession.invalidate();

           response.sendRedirect("loginUserAdmin.jsp");
       }

    }
}
