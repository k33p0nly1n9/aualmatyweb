<%-- 
    Document   : editProfile
    Created on : 29.05.2020, 15:36:42
    Author     : bayan
--%>

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
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Настройки кабинета</title>

    </head>
    <body>
        <jsp:include page="/WEB-INF/auth/header.jsp"/>
        <div class="container-fluid">
            <div class="card" ">
                <div class="row no-gutters">
                    <div class="col-sm-3" style="background: #868e96;">
                        <img src="<%=models.DataUtils.getPersonPhotoPath(p)%>" class="card-img-top h-100" alt="...">
                        <div class="row no-gutters">
                            <button class='btn btn-danger btn-sm' data-toggle='modal' data-target='#deletePhoto'>Удалить фотографию</button>
                            <button class='btn btn-info btn-sm' data-toggle='modal' data-target='#editPhoto'>Сменить</button>
                        </div>
                    </div>

                    <div id="deletePhoto" class="modal fade" tabindex="-1">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">
                                <div class="modal-header">  
                                    <h4 class="modal-title">Предупреждение</h4>
                                    <button class="close" data-dismiss='modal'>x</button>
                                </div>
                                <div class="modal-body">
                                    Вы уверены, что хотите удалить фотографию?
                                </div>
                                <div class="modal-footer">
                                    <form method="post" action="DeleteCurPersonPhoto">
                                        <input  class="btn btn-info" type="submit" name="nDeletePhoto" id="nDeletePhoto" onclick="fdeletePhoto(this)" value="Да">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="editPhoto" class="modal fade" tabindex="-1">
                        <div class="modal-dialog modal-ml">
                            <div class="modal-content">
                                <div class="modal-header">  
                                    <h4 class="modal-title">Выберить фотографию</h4>
                                    <button class="close" data-dismiss='modal'>x</button>
                                </div>
                                <div class="modal-body"> 
                                    <form method="post" action="EditProfile" enctype="multipart/form-data">
                                        <input type="file" name="editfile" id="editfile"><br/>
                                        <!--    </div>
                                        <div class="modal-footer">-->
                                        <input  class="btn btn-info" type="submit" name="upload2" id="upload2" onclick="feditPhoto(this)" value="Загрузить">
                                    </form>
                                </div> 

                            </div>
                        </div>
                    </div>
                    <div>
                        <form method="post" action="EditProfile" enctype="multipart/form-data">
                            Имя :<%=p.getName()%><br/>
                            Фамилия :<%=p.getLastname()%><br/>
                            Мои услуги: 
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

                            Изменить фотографию:
                            <input type="file" name="file" id="file"><br/>
                            <input  class="btn btn-secondary" type="submit" name="upload" id="upload" value="upload"><br/>

                            <a class="btn btn-secondary" href="#" role="button">Редактировать</a> 
                        </form>
                    </div>

                </div>
            </div>
        </div>


        <script>
            function fdeletePhoto(button) {
                $('#deletePhoto').modal("hide");
            }

            function feditPhoto(button) {
                $('#editPhoto').modal("hide");
            }
        </script>
    </body>
</html>
