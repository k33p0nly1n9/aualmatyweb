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
                        <img src="<%=models.DataUtils.getPersonPhotoPath(p)%>" class="card-img-top h-100" alt="...">
                    </div>
                    <div>
                        <b><%=p.getName() + " "+p.getLastname()%></b><br/>
                    Рейтинг: <%=p.getRating()%> <br/>
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
        <a class="btn btn-secondary" href="EditProfile" role="button">Редактировать</a>   
        </div>
    </body>
</html>

<!--   
$sessionScope.personIdSession},
 $per["lastname"]}
<!-- jsp:useBean id="per" class="Person" scope="session"/>-->
<!--<h3>%=p.getName() +","+ p.getLastname()%></h3>-->
