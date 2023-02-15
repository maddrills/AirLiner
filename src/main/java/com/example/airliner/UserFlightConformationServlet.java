package com.example.airliner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UserFlightConformationServlet", value = "/confirmThis")
public class UserFlightConformationServlet extends HttpServlet {
    String gender,passengerAge,passengerName,flightId,from,to,date,cost;
    int sessionUserId;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            from = request.getParameter("from");
            to = request.getParameter("to");
            date = request.getParameter("date");
            cost = request.getParameter("cost");
            passengerName = request.getParameter("passengerName");
            passengerAge = request.getParameter("passengerAge");
            gender = request.getParameter("gender");
        }catch (Exception e){
            System.out.println("Error occurred");
        }


        System.out.println(from+to+date+cost+passengerName+passengerAge+gender);

        if(from == null ||
                to == null ||
                date == null ||
                cost == null ||
                passengerName == null ||
                passengerAge == null ||
                gender == null){
            System.out.println("error");
        }
        else{

            request.getRequestDispatcher("UserPaymentConformation.jsp").forward(request,response);
        }
    }
}
