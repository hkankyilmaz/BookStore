package edu.sabanciuniv.bookstore.Servlets;

import edu.sabanciuniv.bookstore.Entity.Book;
import edu.sabanciuniv.bookstore.Services.BookServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchBookServlet", value = "/SearchBookServlet")
public class SearchBookServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String searchType = request.getParameter("searchType");
        String searchQuery = request.getParameter("searchQuery");

        BookServices bookServices = new BookServices();
        List<Book> books = bookServices.searchBook(searchType, searchQuery);

        request.setAttribute("data", books);
        request.setAttribute("books", books);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
