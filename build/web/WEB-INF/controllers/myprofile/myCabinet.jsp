<%-- 
    Document   : myCabinet
    Created on : 17.05.2020, 15:40:56
    Author     : bayan
--%>

<%@page import="models.*"%>
<%@page import="models.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Person p = models.Account.getCurrentPerson(request);
    DbHelper db = new DbHelper();
    int personId = p.getId();
    Executor executor = null;
    int executorId = db.getExecutorIdByPersonId(personId);
    if (executorId != -1) {
        executor = db.getExecutor(executorId);
        db.loadExecutorServices(executor);
    }
    request.setAttribute("navCurr", "cabinet");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Мои кабинет</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/auth/header.jsp"/>
        <div class="container-fluid">
            <div class="card" ">
                <div class="row no-gutters">
                    <div class="col-sm-3" style="background: #868e96;">
                        <div>
                            <img src="<%=models.DataUtils.getPersonPhotoPath(p)%>" class="card-img-top h-90" alt="...">
                            <a class="btn btn-secondary" href="EditProfile" role="button">Редактировать</a>   
                        </div>
                    </div>

                    <div class="col-sm-7" style=" padding: 20px;"> 
                        <b><%=p.getName() + " " + p.getLastname()%></b><br/>
                        Рейтинг: <%=p.getRating()%> <br/>

                        <%
                            String birth = DataUtils.convertLongToDataString(p.getBirthday());
                        %>
                        Дата рождения: <%=birth%> <br/>
                        <%
                            String created = DataUtils.convertLongToDataString(p.getCreatedDate());
                        %>
                        Дата регистрации: <%=created%> <br/>
                        Мои услуги: <br/>
                        <%
                            if (executor == null || executor.getServices().isEmpty()) {
                        %>
                        <span style="color: gray">(Пусто)</span>
                        <%
                        }
                        else {
                            for (Service s : executor.getServices()) {
                        %>
                        <span class="badge badge-dark"><%=s.getTitle()%></span>
                        <%
                                }
                            }
                        %> <br/>
                    </div>
                </div>
            </div>

            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                </button>
                <div class="collapse navbar-collapse " id="collapsibleNavbar">
                    <nav class="nav nav-pills nav-justified">
                        <a class="nav-link active" href="<%=DataUtils.PATH%>MyCabinet">Профиль</a>
                        <%
                            boolean isexecutor = db.getPersonIsExecutorField(p.getId());
                        %> 

                       <a class=" nav-link" href="<%=DataUtils.PATH%><%if (isexecutor == true) {
                                out.print("MyForm");}
                                else{
                           out.print("CreateForm");}
                            %> ">Анкета</a>
                        <a class=" nav-link" href="<%=DataUtils.PATH%>MyOrders">Мои заказы</a>
                        <a class=" nav-link" href="<%=DataUtils.PATH%>MyReviews">Мои отзывы</a>
                    </nav>
                </div>
            </nav>
        </div>
    </body>
</html>

<!--   
$sessionScope.personIdSession},
 $per["lastname"]}
<!-- jsp:useBean id="per" class="Person" scope="session"/>-->
<!--<h3>%=p.getName() +","+ p.getLastname()%></h3>-->
