<%@ page import="java.util.List" %>
<%@ page import="edu.sabanciuniv.bookstore.Entity.Book" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> Book Store </title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
<h1 class="Header">Welcome The Book Store</h1>
<br/>


<div class="Content--container">

    <div class="left--aside">

        <div class="left--aside-Container">

            <fieldset class="fieldset">

                <legend>Register New Book / Update Book</legend>

                <form id="registerForm" action="saveBookServlet" method="post">
                    <input id="id" type="hidden" name="id" value="">
                    <label for="name">Book Name:</label><br>
                    <input required type="text" id="name" name="name"><br>
                    <label for="title">Book Title:</label><br>
                    <input required type="text" id="title" name="title"><br>
                    <label for="author">Author:</label><br>
                    <input required type="text" id="author" name="author"><br>
                    <label for="year">Publish Year:</label><br>
                    <input required type="text" id="year" name="year"><br>
                    <label for="genre">Genre:</label><br>
                    <input required type="text" id="genre" name="genre"><br>
                    <input id="registerSubmitBtn" type="submit" value="REGISTER">
                    <input id="updateSubmitBtn" style="display: none" type="submit" value="UPDATE">

                </form>
                <button style="display: none" id="cancelBtn">CANCEL</button>

            </fieldset>

            <fieldset class="fieldset">

                <legend>Search Book</legend>

                <form action="SearchBookServlet" method="post">


                    <select id="searchType" name="searchType" required>

                        <option value="">Search Type</option>
                        <option value="title">Title</option>
                        <option value="author">Author</option>

                    </select>
                    <input required type="text" id="searchQuery" name="searchQuery">

                    <input type="submit" value="SEARCH">

                </form>

            </fieldset>


        </div>


    </div>
    <div class="right--aside">


        <div class="right--aside-Container">
            <fieldset class="fieldset">
                <legend>Book List</legend>
                <table class="table">
                    <tr class="row">
                        <th class="cell"><strong>ID</strong></th>
                        <th class="cell"><strong>Name</strong></th>
                        <th class="cell"><strong>Title</strong></th>
                        <th class="cell"><strong>Author</strong></th>
                        <th class="cell"><strong>Publish</strong></th>
                        <th class="cell"><strong>Genre</strong></th>
                        <th class="cell"><strong>Action</strong></th>
                    </tr>
                    <%
                        List<Book> books = (List<Book>) request.getAttribute("books");
                        if (books != null) {
                            for (Book book : books) {
                    %>

                    <%
                        List<Book> data = (List<Book>) request.getAttribute("data");
                        if (data != null) {
                    %>
                    <tr class="row" style="background-color: darkseagreen">

                    </div>
                    <% } else { %>
                    <tr class="row">
                    <% } %>

                        <td class="cell"><%= book.getBookId() %>
                        </td>
                        <td class="cell"><%= book.getBookName() %>
                        </td>
                        <td class="cell"><%= book.getBookTitle() %>
                        </td>
                        <td class="cell"><%= book.getBookAuthor() %>
                        </td>
                        <td class="cell"><%= book.getBookPublisher() %>
                        </td>
                        <td class="cell"><%= book.getGenre() %>
                        </td>
                        <td style="" class="cell actions">
                            <form style="margin: 0 10px 0 0;" method="post" action="DeleteBookServlet">
                                <input type="hidden" name="id" value="<%= book.getBookId() %>">
                                <input id="deleteInput" type="submit" value="Delete">
                            </form>
                            <button data-form='{

                            "id" : "<%= book.getBookId() %>",
                            "name" : "<%= book.getBookName() %>",
                            "title" : "<%= book.getBookTitle() %>",
                            "author" : "<%= book.getBookAuthor() %>",
                            "year" : "<%= book.getBookPublisher() %>",
                            "genre" : "<%= book.getGenre() %>"


                            }'
                                    id="updateInputBtn"
                                    class="updateInputBtn">Update

                            </button>
                        </td>

                    </tr>
                    <% }
                    } %>


                </table>
                <form id="getAllBooksForm" method="get" action="GetAllBookServlet">
                    <input style="margin-top: 30px;width: 100%" id="getAllBooks" type="submit" value="Get All Books">
                </form>
            </fieldset>
        </div>


    </div>

</div>


<%
    String[] info = (String[]) request.getAttribute("info");
    if (info != null) {
%>
<div class="info--container">
    <h2>The Book Registered</h2>
    <% for (String item : info) { %>
    <p><%= item %>
    </p>
    <% } %>
</div>
<% } %>

<%
    List<Book> data = (List<Book>) request.getAttribute("data");
    if (data != null && data.isEmpty()) {
%>

<div class="info--container">
    <h2>Sorry, No match !</h2>
    <p> We dont any match your seaarch....  </p>


</div>
<% } %>


<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.12.5/gsap.min.js"></script>
<script src="index.js"></script>

</body>
</html>