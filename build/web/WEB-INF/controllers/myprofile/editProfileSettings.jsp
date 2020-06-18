<%-- 
    Document   : editProfileSettings
    Created on : 18.06.2020, 1:27:49
    Author     : bayan
--%>

<%@page import="models.DataUtils"%>
<%@page import="models.Executor"%>
<%@page import="models.DbHelper"%>
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

    String errorStr = (String) request.getAttribute("settingserror");
    String saved = (String) request.getAttribute("settingssaved");

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
                    <div class="col-sm-3 col-md-3 col-lg-3"  >
                        <div>
                        <img src="<%=models.DataUtils.getPersonPhotoPath(p)%>" class="card-img-top h-100" alt="...">
                        <div class="row no-gutters">
                            <button class='btn btn-danger btn-sm' data-toggle='modal' data-target='#deletePhoto'>Удалить фотографию</button>
                            <button class='btn btn-info btn-sm' data-toggle='modal' data-target='#editPhoto'>Сменить</button>
                        </div> 
                        </div>
                    </div>

                    <div class="row no-gutters " >
                        <div class="col-sm-7 col-md-7 col-lg-7" style=" padding: 20px;" >
                            <%            if (errorStr != null) {
                                    out.print("<span style='color:red;'>" + errorStr + "</span>");
                                }
                                else if (saved != null) {
                                    out.print("<span style='color:blue;'>" + saved + "</span>");
                                }
                            %>
                            <div>

                                <div class="row no-gutters " id="editnumber">
                                    Мобильный телефон:
                                    <%
                                        String nn = p.getNumber();
                                        String n2 = nn.substring(0, 8) + "***";
                                    %>
                                    <p4><%=n2%></p4>
                                </div>
                                <form method="post" action="EditProfileSettings">
                                    <div id="resultnumber"  class="collapse in">
                                        <div>Новый номер:</div>
                                        <div>
                                            <input type="number"  id="profilesetetNumb"  name="profilesetetNumb" />
                                        </div>


                                        <button class="btn btn-primary" type="submit">Сохранить новый номер</button>
                                    </div>
                                </form>
                            </div>
                            <form method="post" action="EditProfileSettings">
                                <div id="resultpasswd"  class="collapse in">
                                    <div>Текущий пароль:</div>
                                    <div>
                                        <input type="text"  id="profilesetetoldpasswd"  name="profilesetetoldpasswd" />
                                    </div> 

                                    <div>Новый пароль:</div>
                                    <div>
                                        <input type="text"  id="profilesetetPasswd"  name="profilesetetPasswd" />
                                    </div>  

                                    <div>Подтвердите новый пароль:</div>
                                    <div>
                                        <input type="text"  id="profilesetetPasswdconfirm"  name="profilesetetPasswdconfirm" />
                                    </div> 


                                    <button class="btn btn-primary" type="submit">Сохранить новый пароль</button> 
                                </div>
                            </form>
                        </div>
                        <div class=" col-sm-1 col-md-1 col-lg-1">
                            <div style="margin-top: 30px;">
                                <input type="button"  id="profilesetbtnnum" value="Изменить номер"
                                       data-toggle='collapse' data-target='#resultnumber'/>
                            </div>

                            <div style="margin-top: 40px;">
                                <input type="button"  id="profilesetbtnpasswd" value="Изменить пароль"
                                       data-toggle='collapse' data-target='#resultpasswd'/>
                            </div>
                        </div>
                    </div>

                     <div class="nav flex-column nav-pills  col-sm-2 col-md-2 col-lg-2" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                        <a class="nav-link" id="v-pills-home-tab"  href="<%=DataUtils.PATH%>EditProfile" role="tab" aria-selected="false">Персональные данные</a>
                        <a class="nav-link active" id="v-pills-profile-tab"  href="<%=DataUtils.PATH%>EditProfileSettings" role="tab"  aria-selected="true">Аккаунт</a>
                    </div>

                </div>
            </div>
        </div>
        <script type="text/javascript">
            function fdeletePhoto(button) {
                $('#deletePhoto').modal("hide");
            }

            function feditPhoto(button) {
                $('#editPhoto').modal("hide");
            }

            function fgetNumber() {
                var id = <%=p.getId()%>;
                $.get("<%=DataUtils.PATH%>?=" + id,
                        function (data, status) {
                            $("#").html(data)
                        }
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
