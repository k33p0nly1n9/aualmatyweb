<%-- 
    Document   : createForm
    Created on : 18.06.2020, 11:36:14
    Author     : bayan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="models.*"%>
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

    ArrayList<Service> services = new ArrayList();
    ArrayList<Service> selectionList;
%>
<!DOCTYPE html>
<html>
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
                            out.print("MyForm");
                        }
                        else {
                            out.print("CreateForm");
                        }
                       %> ">Анкета</a>
                    <a class=" nav-link" href="<%=DataUtils.PATH%>MyOrders">Мои заказы</a>
                    <a class=" nav-link" href="<%=DataUtils.PATH%>MyReviews">Мои отзывы</a>
                </nav>
            </div>
        </nav>
        <div>
            <form id='createformId'  enctype="multipart/form-data" action="CreateForm" method="post">
                <div class="col-md-4 mb-3">
                    <label for="myformcoverimage">Фотография обложки</label>
                    <input id="myformcoverimage" type="file" class="form-control" name="myformcoverimage" multiple="multiple" />
                </div>
                <div class="col-md-4 mb-3">
                    <label for="myformspec">Специализация</label>
                    <input id="myformspec" type="text" class="form-control" name="myformspec" multiple="multiple" />
                </div>
                <div class="col-md-4 mb-3">
                    <label for="myformdesc">Описание о вас и вашей деятельности</label>
                    <input id="myformdesc" type="text" class="form-control" name="myformdesc" multiple="multiple" />
                </div>


                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Раздел
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <%
                            ArrayList<String> sections = db.getSectionsInString();
                            for (String s : sections) {%>
                            <a class="dropdown-item"><%=s%></a>
                            <%}

                            %>

                    </div>
                </div>


                <div class="col-sm-4">
                    <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#newServiceModal">
                     Добавить услугу
                    </button>
                </div>

                          Услуги 
                <div class="card" ">
                    <%for (Service s : services) {%>
                    <%
                        String title = s.getTitle();
                        Double price = s.getPrice();
                    %>
                    <div class="row no-gutters">

                        <div class="card-body">
                            <h4 class="card-title"><%=title%></h4>
                        </div> 
                        <div class="card-text">
                            <p class="card-text"><%=price%></p>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                            <label class="form-check-label" for="inlineCheckbox1">1</label>
                        </div>
                    </div>
                    <%}%>
                </div>

            </form> 
            <button id="submitFiles" class="btn btn-primary" type="submit" name="button">Создать</button>
        </div>
    </div>
</body>
<script>

    var i = 0;
    var list = document.getElementById("createformId").lastElementChild.id;
    document.getElementById(list).onchange = function () {
        var ul = document.createElement('input');
        ul.setAttribute('type', 'file');
        ul.setAttribute('id', 'myformcoverimage' + i);
        ul.setAttribute('name', 'myformcoverimage' + i);

        var content = document.getElementById("filePoster");
        insertAfter(content, ul);
        i++;
    };

    function insertAfter(referenceNode, newNode)
    {
        referenceNode.parentNode.insertBefore(newNode, referenceNode.nextSibling);
    }

 function insertDataToRequest()
    {
       request.setAttribute("addservice", services);
    }


</script>

   <div class="modal fade" id="newServiceModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form method="post" action="AddService">
                        <div class="modal-header">
                            <h5 class="modal-title" id="responseModalLabel">Добавить услугу</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">

                            <label for="newServiceTitle">Название</label>
                            <input type="text" class="form-control is-valid" id="newServiceTitle" name="newServiceTitle" value="" required>
                            <div class="invalid-feedback">
                                Пожалуйста, введите валидные данные.
                            </div>
                            
                            
                            <label for="newServicePrice">Цена</label>
                            <input type="number" class="form-control is-valid" id="newServicePrice" name="newServicePrice" value="" required>
                            <div class="invalid-feedback">
                                Пожалуйста, введите валидные данные.
                            </div>
>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                            <button type="submit" class="btn btn-secondary" onclick='' data-dismiss="modal">Сохранить</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
</html>
