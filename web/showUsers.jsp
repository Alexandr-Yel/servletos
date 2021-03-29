<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Список пользователей</title>
    <style>
        #win {
            width: 200px;
            height: 70px;
            text-align: left;
            padding: 20px;
            border: 3px solid #696969;
            background: #e6e6ff;
            border-radius: 5px;
            color: #696969;
            display: none;
            position: absolute;
            top: 10px;
            right: 0;
            bottom: 0;
            left: 300px;
            /*margin: auto;*/
        }

        #win:target {
            display: block;
        }

        .close {
            display: inline-block;
        }

        .close:hover {
            background: #e6e6ff;
        }
    </style>
</head>
<body vlink="black" link="black" alink="black">
<button><a href="#win" style="text-decoration: none;">Добавить нового пользователя</a></button>
<table border="1">
    <c:forEach var="users" items="${users}">
        <tr>
            <td>${users.getFirstname()}</td>
            <td>${users.getLastname()}</td>
            <td>
                <form action="/main" method="post">
                    <input name="firstname" type="hidden" value="${users.getFirstname()}"/>
                    <input name="lastname" type="hidden" value="${users.getLastname()}"/>
                    <button type="submit" value="delete" name="action">Удалить</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


<div id="win">
    <form action="/main" method="post">
        <b>Name</b><br>
        <input placeholder="first name" name="firstname" type="text"/><br>
        <input placeholder="last name" name="lastname" type="text"/><br>
        <button type="submit" value="add" name="action">Добавить</button>
        <button><a href="#" class="close" style="text-decoration: none;">Закрыть</a></button>
    </form>
</div>

</body>
</html>