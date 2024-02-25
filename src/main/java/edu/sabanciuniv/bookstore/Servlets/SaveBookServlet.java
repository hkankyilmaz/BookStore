package edu.sabanciuniv.bookstore.Servlets;


import edu.sabanciuniv.bookstore.Services.BookServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "saveBookServlet", value = "/saveBookServlet")
public class SaveBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            String name = req.getParameter("name");
            String title = req.getParameter("title");
            String author = req.getParameter("author");
            String publishYear = req.getParameter("year");
            String genre = req.getParameter("genre");

            String[] info = {title, author, publishYear, genre};

            BookServices bookServices = new BookServices();
            bookServices.saveBook(title,name, author, publishYear, genre);

            req.setAttribute("info", info);
            req.getRequestDispatcher("index.jsp").forward(req, resp);


        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
