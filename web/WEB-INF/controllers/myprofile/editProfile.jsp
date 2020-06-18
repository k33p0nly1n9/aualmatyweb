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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8, width=device-width, initial-scale=1"">
       
        <title>Настройки кабинета</title>

    </head>
    <body>
        <jsp:include page="/WEB-INF/auth/header.jsp"/>
        <div class="container-fluid">
            <div class="card" ">
                <div class="row no-gutters">
                    <div class="col-sm-3" >
                        <div>
                            <img src="<%=models.DataUtils.getPersonPhotoPath(p)%>" class="card-img-top h-100" alt="...">
                            <div class="row no-gutters">
                                <button class='btn btn-danger btn-sm' data-toggle='modal' data-target='#deletePhoto'>Удалить фотографию</button>
                                <button class='btn btn-info btn-sm' data-toggle='modal' data-target='#editPhoto'>Сменить</button>
                            </div> 
                        </div>
                    </div>

                    <div class="col-sm-7" style=" padding: 20px;" >
                        <form method="post" action="EditProfile" enctype="multipart/form-data">
                            <div>
                                <div>Имя:</div>
                                <div>
                                    <input type="text" value="<%=p.getName()%>" id="editName"  name="editName"  />
                                </div>
                            </div>

                            <div>
                                <div>Фамилия:</div>
                                <div>
                                    <input type="text" value="<%=p.getLastname()%>" id="editLastname"  name="editLastname"  />
                                </div>
                            </div>

                            <div>
                                <div>Дата рождения:</div>
                                <div>
                                    <%
                                        Long l = p.getBirthday();

                                        String s = "";
                                        if (l != null) {
                                            s = DataUtils.convertLongToDataString(p.getBirthday());
                                        }
                                    %>
                                    <input type="date" value="<%=s%>" id="editBirthday" name="editBirthday"  />
                                </div>
                            </div>
                            <button class="btn btn-primary" type="submit">Сохранить</button>
                        </form>
                    </div>
                 
                    <div class="nav flex-column nav-pills  col-sm-2 col-md-2 col-lg-2" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                        <a class="nav-link active" id="v-pills-home-tab" href="<%=DataUtils.PATH%>EditProfile" role="tab"  aria-selected="true">Персональные данные</a>
                        <a class="nav-link" id="v-pills-profile-tab"  href="<%=DataUtils.PATH%>EditProfileSettings" role="tab"  aria-selected="false">Аккаунт</a>
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
    </body>
</html>
