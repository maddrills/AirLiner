package com.example.airliner;

import com.prepairedStatements.PrepareStatementz;
import com.prepairedStatements.PreparedStatementToAddFlightDataByAdmin;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminAddNewFlightServlet" ,value = "/addNewFlight")
public class AdminAddNewFlightServlet extends HttpServlet {
    String from,to,date;
    int cost;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try{

        from = request.getParameter("from");
        to = request.getParameter("to");
        date = request.getParameter("flightDate");
        cost = Integer.parseInt(request.getParameter("cost"));}
        catch (Exception e){
            System.out.println("Error");
        }


        System.out.println(from+" "+to+" "+date+" "+cost);

        if(from == null || to == null || date == null || cost < 0){
            System.out.println("null out");

            response.sendRedirect("adminAddFlightView.jsp");
        }
        else{
            HttpSession session = request.getSession(false);

            System.out.println("session is   "+session);

            if(session != null) {
                PrepareStatementz preparedStatementToAddFlightDataByAdmin = new PreparedStatementToAddFlightDataByAdmin(from, to, date, cost);
                try {
                    preparedStatementToAddFlightDataByAdmin.resultSet();
                } catch (SQLException e) {
                    System.out.println("error while putting flight data");
                }
                response.sendRedirect("adminAddFlightView.jsp");
            }
            else {
                response.sendRedirect("AdminLogin.jsp");
            }
        }
    }
}
