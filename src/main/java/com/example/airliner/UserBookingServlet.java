package com.example.airliner;

import com.prepairedStatements.PrepairedStatementGetAllFlightDataByFlightId;
import com.prepairedStatements.PrepareStatementz;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "UserBookingServlet", value = "/userBooking")
public class UserBookingServlet extends HttpServlet {

    int flightId;
/*    int passengers;*/
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try{

/*        passengers = Integer.parseInt(request.getParameter("passengers"));*/

        flightId = Integer.parseInt(request.getParameter("flightId"));}
        catch (Exception e){
            System.out.println("Error");
            try {
                response.sendRedirect("index.jsp");
            } catch (IOException ex) {
                System.out.println("Error in redirection");
            }
        }

        System.out.println("passengers"+" "+flightId);

        PrepareStatementz prepairedStatementGetAllFlightDataByFlightId = new PrepairedStatementGetAllFlightDataByFlightId(flightId+"");

/*        Cookie cookieFlightId = new Cookie("flightId",flightId+"");
        Cookie cookiePassengers = new Cookie("flightId",passengers+"");


        response.addCookie(cookieFlightId);
        response.addCookie(cookiePassengers);*/

        ResultSet resultSet = null;
        try {
            resultSet = prepairedStatementGetAllFlightDataByFlightId.resultSet();
            request.setAttribute("resultSet",resultSet);
        } catch (SQLException e) {
            System.out.println("Statement Exception");
        }


        request.getRequestDispatcher("userBookingPage.jsp").forward(request,response);
    }
}
