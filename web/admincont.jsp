<%-- 
    Document   : admincont
    Created on : Oct 9, 2016, 1:16:49 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        body{
            background-color: #e9eaed;
        }

        .category{
            background-color: #CCCCCC;
            margin: auto;
            margin-top: 50px;
            width: 70%;
            border: 3px solid blue;
            padding: 10px;
            text-align: center;
            box-shadow: inset 0px 0px 10px 2px rgba(255,255,255,0.4);
            font-size: 20px;

        }


        table, th, td {
            border: 2px solid black;
            background-color:  #4c4c4c;
            color: #FFFFFF;
        }
        input[type=submit] {
            padding:5px 15px; background:#ccc; border:0 none;
            cursor:pointer;
            -webkit-border-radius: 5px;
            border-radius: 5px;
        }
        #spaceRow{
            background-color: red;
            height: 20px;
        }

    </style>
    <script>
        function areYouSure() {
            windows.confirm("Are you sure you want to delete this category ?");
        }
    </script>
    <body >
        <h1 style="text-align:center;">${param.update_message}</h1>
        <table class="category">
            <tr>    
                <td>Catregory name</td>
                <td>Category id</td>
                <td>Edit Category name</td>
                <td>Delete category and all phones on it</td>
            </tr>
            <c:forEach var="cate" items="${allCA}">
                <tr>
                    <td>${cate.value.name}</td>
                    <td>${cate.value.id}</td>
                    <td>
                        <form method="POST" action="updateCategory">
                            Enter new name: <input type="text" name="newName">
                            <input type="hidden" name="caId" value="${cate.value.id}">
                            <input type="hidden" name="updateType" value="changeName">
                            <input type="submit" value="Edit">
                        </form>
                    </td>
                    <td>
                        <form method="POST" action="updateCategory">
                            <input type="hidden" name="caId" value="${cate.value.id}">
                            <input type="hidden" name="updateType" value="delete">
                            <input type="submit" value="Delte" style="background:red;" onclick="return confirm('Are you sure?')">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <tr> 
                <td>Add new</td> <!-- skip name -->
                <td colspan="3">
                    <form method="POST" action="updateCategory">
                        new name: <input type="text" name="newName">
                        new id:   <input type="number" name="caId">
                        <input type="hidden" name="updateType" value="addCategory">
                        <input type="submit" value="ADD   " style="background: green">
                    </form>
                </td>
            </tr>
        </table>
        <h1 style="text-align: center">All Phones</h1>
        <table class="category">
            <tr>    
                <td>Phone name</td>
                <td>Phone id</td>
                <td>Phone Category id</td>
                <td>Phone Cost</td>
                <td>Edit photo</td>
                <td>Delete</td>
            </tr>
            <tr id="spaceRow"></tr>
            <c:forEach var="ph" items="${allPH}">
                <c:set var="curPhId" value="${ph.value.id}" scope="application"/>
                <tr>
                    <td>${ph.value.name}</td>
                    <td>${ph.value.id}</td>
                    <td>${ph.value.category_id}</td>
                    <td>${ph.value.cost}</td>
                    <td>${ph.value.img_path}</td>
                </tr>
                <tr>
                    <td> <!-- edit name -->
                        <form action="updatePhone" method="post" >
                            <input type="text" name="newName"/>
                            <input type="hidden" name="reqType" value="editName">
                            <input type="hidden" name="phId" value="${ph.value.id}">
                            <input type="submit" value="Edit" />
                        </form>  
                    </td>
                    <td><!-- don't edit id -->
                    </td>
                    <td><!-- edit category id -->
                        <form action="updatePhone" method="post" >
                            <input type="number" name="newCategoryId"/>
                            <input type="hidden" name="reqType" value="editCategoryId">
                            <input type="hidden" name="phId" value="${ph.value.id}">
                            <input type="submit" value="Edit" />
                        </form>  
                    </td>
                    <td><!-- edit cost -->
                        <form action="updatePhone" method="post" >
                            <input type="number" name="newCost"/>
                            <input type="hidden" name="reqType" value="editCost">
                            <input type="hidden" name="phId" value="${ph.value.id}">
                            <input type="submit" value="Edit" />
                        </form>  
                    </td>
                    <td><!-- edit photo -->
                        <form action="updatePhone" method="post" >
                            <input type="text" name="newImgPath"/>
                            <input type="hidden" name="reqType" value="editIMG">
                            <input type="hidden" name="phId" value="${ph.value.id}">
                            <input type="submit" value="Edit" />
                        </form>  
                    </td>
                    <td><!-- remove -->
                        <form action="updatePhone" method="post" >
                            <input type="hidden" name="reqType" value="deletePhone">
                            <input type="hidden" name="phId" value="${ph.value.id}">
                            <input type="submit" value="Delete" style="background:red;" onclick="return confirm('Are you sure?')"/>
                        </form>  
                    </td>
                </tr>
                <tr id="spaceRow"></tr>
            </c:forEach>
            <tr> 
                <td>Add new</td> <!-- skip name -->
                <td colspan="5" align="left">
                    <form method="POST" action="updatePhone">
                        Name:<input type="text" name="newName"> <br/>
                        Id: <input type="number" name="phId"> <br/>
                        Category id: <input type="number" name="newCategoryId"> <br/>
                        Cost: <input type="number" name="newCost"> <br/>
                        image name: <input type="text" name="newImgName"> <br/>
                        <input type="hidden" name="reqType" value="addPhone"> 
                        <input type="submit" value="ADD   " style="background: green">
                    </form>
                </td>
            </tr>
        </table>
    </body>

</html>
