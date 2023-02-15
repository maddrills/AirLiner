package com.example.airliner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name = "AdminLogOutServlet", value = "/logOutAdmin")
public class AdminLogOutServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        //remove admin session
        if (request.getParameter("logOut") != null) {
            session.invalidate();
            request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
        }
    }
}
