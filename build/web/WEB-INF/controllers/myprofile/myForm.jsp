<%-- 
    Document   : myForm
    Created on : 18.06.2020, 7:47:19
    Author     : bayan
--%>

<%@page import="models.Service"%>
<%@page import="models.Executor"%>
<%@page import="models.DbHelper"%>
<%@page import="models.Person"%>
<%@page import="models.DataUtils"%>
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


                    <div class="col-sm-1" style="background: #868e96;">
                        <img src="<%=models.DataUtils.getPersonPhotoPath(p)%>" class="card-img-top " alt="...">
                    </div>
                    <p  style=" padding: 20px;"><b><%=p.getName() + " " + p.getLastname()%></b></p> 

                </div>
            </div>

            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                </button>
                <div class="collapse navbar-collapse " id="collapsibleNavbar">
                    <nav class="nav nav-pills nav-justified">
                        <a class="nav-link " href="<%=DataUtils.PATH%>MyCabinet">Профиль</a>
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
            <div>
                <form id='formcover' class="imagePoster" enctype="multipart/form-data" action="#" method="post">
                    <input id="myformcoverimage" type="file" class="form-control" name="myformcoverimage" onchange='changedcover' multiple="multiple" />
                   
                </form> 
                <button id="submitFiles" class="btn btn-primary" type="submit" name="button">Создать</button>
            </div>
        </div>
    </body>
    <script>

        var i = 0;
       function changedcover() {
            var ul = document.createElement('input');
            ul.setAttribute('type', 'file'); 
                ul.setAttribute('onchange', 'changedcover'); 
            ul.setAttribute('id', 'myformcoverimage'+i);
            ul.setAttribute('name', 'myformcoverimage' + i);

            var content = document.getElementById("myformcoverimage");
            insertAfter(content, ul);
            i++;
        };

        function insertAfter(referenceNode, newNode)
        {
            referenceNode.parentNode.insertBefore(newNode, referenceNode.nextSibling);
        }


    </script>
</html>
