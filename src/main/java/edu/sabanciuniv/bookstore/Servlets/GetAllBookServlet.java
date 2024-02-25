package edu.sabanciuniv.bookstore.Servlets;


import edu.sabanciuniv.bookstore.Services.BookServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GetAllBookServlet", value = "/GetAllBookServlet")
public class GetAllBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {

            BookServices bookServices = new BookServices();
            var books = bookServices.getAllBook();
            req.setAttribute("books", books);
            req.getRequestDispatcher("index.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
