package com.example.airliner;

import com.prepairedStatements.PrepareStatementz;
import com.prepairedStatements.PreparedStatementGetFlightDataByDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "UserFlightSearchServlet", value = "/searchFlight")
public class UserFlightSearchServlet extends HttpServlet {

    String from,to,date,userId;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        from = request.getParameter("from");
        to = request.getParameter("to");
        date =request.getParameter("flightDate");

        System.out.println(from+" "+to+" "+date);

        if(from == null || to == null || date == null){

            System.out.println("Empty Entry data field");

        }
        else{

            PrepareStatementz preparedStatementGetFlightDataByDate = new PreparedStatementGetFlightDataByDate(from,to,date);

            ResultSet resultSet = null;
            try {
                resultSet = preparedStatementGetFlightDataByDate.resultSet();
/*                while (resultSet.next()){
                    System.out.println(            resultSet.getString("fromAir"));
                    System.out.println(            resultSet.getString("toAir"));
                    System.out.println(            resultSet.getString("date_of_departure"));
                }*/
            } catch (SQLException e) {
                System.out.println("Exception in collecting data");
            }

            request.setAttribute("flightData", resultSet);

            request.getRequestDispatcher("index.jsp").forward(request,response);

        }
    }
}
