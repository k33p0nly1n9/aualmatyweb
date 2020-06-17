<%-- 
    Document   : signup
    Created on : 17.05.2020, 16:39:00
    Author     : bayan
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    String errorStr = (String) request.getAttribute("signuperror");

    request.setAttribute("navCurr", "signup");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>


        <div class="container">
            <h1>Введите свои данные</h1>

            <form method="post" enctype="multipart/form-data"> 
                <%            if (errorStr != null) {
                        out.print("<span style='color:red;'>" + errorStr + "</span>");
                    }
                %>
                <div class="form"> 

                    <div class="col-md-4 mb-3">
                        <label for="personName">Имя:</label><br/>
                        <input type="text" class="form-control is-valid" id="personName" name="personName" value="" required>
                        <div class="invalid-feedback">
                            Пожалуйста, введите валидные данные.
                        </div>
                    </div>

                    <div class="col-md-4 mb-3">
                        <label for="personLast">Фамилия:</label><br/>
                        <input type="text" class="form-control is-valid" id="personLast" name="personLast" value="" required>
                        <div class="invalid-feedback">
                            Пожалуйста, введите валидные данные.
                        </div>
                    </div>

                    <div class="col-md-4 mb-3">
                        <label for="signupphoto">Фотография:</label><br/>
                        <input type="file" name="signupphoto" id="signupphoto"><br/>
                    </div>

                    <div class="col-md-4 mb-3">
                        <label for="birthday">Дата рождения:</label><br/>
                        <input type="date" class="form-control is-valid" id="birthday" name="birthday" value="" required>
                        <div class="invalid-feedback">
                            Пожалуйста, введите валидные данные.
                        </div>


                    </div>  <div class="col-md-4 mb-3">
                        <label for="number">Номер:</label><br/>
                        <input type="text" class="form-control is-valid" id="number" name="number" value="" required>
                        <div class="invalid-feedback">
                            Пожалуйста, введите валидные данные.
                        </div>
                    </div>


                    <div class="col-md-4 mb-3">
                        <label for="passwd">Пароль:</label><br/>
                        <input type="password" class="form-control is-valid" id="passwd" name="passwd" value="" required>
                        <div class="invalid-feedback">
                            Пожалуйста, введите валидные данные.
                        </div>
                    </div>

                    <div class="col-md-4 mb-3">
                        <label for="confirm">Подтвердите пароль:</label><br/>
                        <input type="password" class="form-control is-valid" id="confirm" name="confirm" value="" required>
                        <div class="invalid-feedback">
                            Пожалуйста, введите валидные данные.
                        </div>
                    </div>

                    <button class="btn btn-primary" type="submit">Зарегистрироваться</button> 
                </div> 
        </div>
    </form>
</div>
</body>
</html>
