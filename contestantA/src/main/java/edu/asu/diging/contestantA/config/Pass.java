package edu.asu.diging.contestantA.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Pass extends HttpServlet {
//	Play playedNumber;

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      String num = request.getParameter("submit");
//      game.addNumberPlayerOne(num);
  }           
}