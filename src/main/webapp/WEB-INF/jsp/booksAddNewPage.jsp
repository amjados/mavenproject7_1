<%-- 
    Document   : nameView
    Created on : Sep 18, 2014, 6:53:20 PM
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
        <title>Book->New</title>
    </head>
    <body>   
        <h1>Enter New Book</h1>

        <form:form method="post" commandName="bookAddNew">
            <form:hidden path="bookid" />
            <table>
                <tr>
                    <td>subject:</td>
                    <td><form:input path="subject" /></td>
                    <td>
                        <font style="color: red">
                        <form:errors path="subject" cssClass="error"/>
                        </font>
                    </td>
                </tr>
                <tr>
                    <td>title:</td>
                    <td><form:input path="title" /></td>
                    <td>
                        <font style="color: red">
                        <form:errors path="title" cssClass="error"/>
                        </font>
                    </td>
                </tr>

                <tr>
                    <td>publisher:</td>
                    <td><form:input path="publisher" /></td>
                    <td>
                        <font style="color: red">
                        <form:errors path="publisher" cssClass="error"/>
                        </font>
                    </td>
                </tr>

                <tr>
                    <td>edition:</td>
                    <td><form:input path="edition" /></td>
                    <td>
                        <font style="color: red">
                        <form:errors path="edition" cssClass="error"/>
                        </font>
                    </td>
                </tr>

                <tr>
                    <td>shelfno:</td>
                    <td><form:input path="shelfno" /></td>
                    <td>
                        <font style="color: red">
                        <form:errors path="shelfno" cssClass="error"/>
                        </font>
                    </td>
                </tr>

                <tr>
                    <td>pages:</td>
                    <td><form:input path="pages" /></td>
                    <td width="60%">
                        <font style="color: red">
                        <form:errors path="pages" cssClass="error"/>
                        </font>
                    </td>
                </tr>

            </table>
            <input type="submit" align="center" name="approveParam" value="Add/Update">
        </form:form>  
        </body>
        </html>
