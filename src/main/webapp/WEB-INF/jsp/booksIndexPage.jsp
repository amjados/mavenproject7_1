<%-- 
    Document   : helloView
    Created on : Sep 18, 2014, 6:44:10 PM
    Author     : Amjad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book->List</title>
    </head>
    <body>       

           <h3>Search Book List</h3>
        <form:form method="post" commandName="bookSearch">
            <table>
                <tr><td>For Exm: subject %4% </td><td> title %4% </td></tr>
                <tr>
                    <td>subject:</td>
                    <td><form:input path="subject" value="${booksMessage.subject}" /></td>
                    <td>
                        <font style="color: red">
                        <form:errors path="subject" cssClass="error"/>
                        </font>
                    </td>
                </tr>
                <tr>
                    <td>title:</td>
                    <td><form:input path="title" value="${bookSearch.title}" /></td>
                    <td>
                        <font style="color: red">
                        <form:errors path="title" cssClass="error"/>
                        </font>
                    </td>
                </tr>
                </table>
                <input type="submit" align="center" name="approveParam" value="Search">
                <input type="submit" align="center" name="approveParam" value="All">
                
           </form:form>  
        <br>
        <a href="add.htm">AddNew</a>
        <br>
        <table border="1">
            <c:forEach var="listValue" items="${lists}">                           
                <tr>
                    <td colspan="2" >${listValue.bookid}</td>               
                    <td><input type="text" value="${listValue.title}"></td>
                    <td><a href="add.htm?id=${listValue.bookid}">Update</a></td>
                    <td><input type="checkbox" value="${listValue.bookid}"></td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" align="center" value="Delete">
 
<%--
        ============================<br/>        
             <table>
                <tr><td>subject</td><td>                
                        <input type="text" name="subject" value="${booksMessage.subject}"><br/>
                    </td></tr>

                <tr><td>title</td><td>                
                        <input type="text" name="title" value="${booksMessage.title}"><br/>
                    </td></tr>

                <tr><td>publisher</td><td>                
                        <input type="text" name="publisher" value="${booksMessage.publisher}"><br/>
                    </td></tr>
                <tr><td>edition</td><td>                
                        <input type="text" name="edition" value="${booksMessage.edition}"><br/>
                    </td></tr>
                <tr><td>pages</td><td>                
                        <input type="text" name="pages" value="${booksMessage.pages}"><br/>
                    </td></tr>
                <tr><td>shelfno</td><td>                
                        <input type="text" name="shelfno" value="${booksMessage.shelfno}"><br/>
                    </td></tr>                
            </table>
--%>        

        
    </body>
</html>
