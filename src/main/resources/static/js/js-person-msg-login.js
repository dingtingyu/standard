$(function () {

    $("#form-add-loginUser").hide();

    //隐藏账号是否存在提示
    // $("#name_is_repeat").css("color","#ffffff00");

    let passIsSame = false;
    let nameIsExit = true;

    $.ajax({
        url: "/getAllLoginUser",
        type: "get",
        success: function (data) {
            replaceData(data);
        },error:function () {
            console.error("get loginUser error!");
        }
    });

    $("#li-add-loginUser").click(function () {
        $("#form-add-loginUser").show();
    });



    function replaceData(data) {
        let htmlStr = "";
        for (let i = 0; i < data.length; i++) {
            htmlStr += "<tr>";
            htmlStr += "<td>" + (i + 1) + "</td>";
            htmlStr += "<td>" + data[i].id + "</td>";
            htmlStr += "<td>" + data[i].name + "</td>";
            htmlStr += "<td>" + data[i].password + "</td>";
            htmlStr += "<td>" + data[i].grade + "</td>";
            htmlStr += "<td>" + data[i].realname + "</td>";
            htmlStr += "<td>" + data[i].age + "</td>";
            htmlStr += "<td>" + data[i].phone + "</td>";
            htmlStr += "<td><a class='button_delete' id='deleteUser' name='deleteUser'>删除</a></td>>";
            htmlStr += "</tr>";
        }
        $("#tbody").html(htmlStr);
    }

    $("#cancel").click(function () {
        $("#form-add-loginUser").hide();
        $("#form-add-loginUser form_group input").val("");
    });

    $("#ok").click(function () {
       if(passIsSame && !nameIsExit){
           let name = $("#loginUser_name").val();
           let password = $("#loginUser_pass").val();
           let grade = $("#loginUser_grade").val();
           let realname = $("#loginUser_realname").val();
           let age = $("#loginUser_age").val();
           let phone = $("#loginUser_phone").val();
           $.ajax({
               url: "/addLoginUser",
               type: "get",
               data: {name:name,password:password,grade:grade,realname:realname,age:age,phone:phone},
               success: function () {
                   console.log("添加用户成功！");
                   alert("添加用户成功!");
                   $("#form-add-loginUser").hide();
                   $("#form-add-loginUser form_group input").val("");
                   $("#person-msg-login").click();
               },error:function () {
                   console.error("添加用户失败！");
                   alert("添加用户失败!");
               }
           });
       }else{
           alert("用户名存在或密码两次不同");
       }
    });


    $('#loginUser_name').on('input propertychange', function() {
        // jQuery.event.trigger( "ajaxStop" );
        var str = $(this).val();//获取输入框的值
        var strLength = $(this).val().length; //获取值的长度
        // console.log(str);
        if(str==""){
            $("#name_is_repeat").css("color","#ffffff00");
        }else{
            $.ajax({
                url: "/isExitUser",
                type: "get",
                async: false,
                data: {name:str},
                success:function (data) {
                    if(data){
                        // console.log("data争取！");
                        $("#name_is_repeat").css("color","red");
                        $("#name_is_repeat").removeClass("fa-check-circle").addClass("fa-exclamation-circle");
                        nameIsExit = true;
                    }else{
                        // console.log("data 错误！");
                        $("#name_is_repeat").css("color","green");
                        $("#name_is_repeat").removeClass("fa-exclamation-circle").addClass("fa-check-circle");
                        nameIsExit = false;
                    }
                }
            });
        }
    });

    $('#loginUser_pass2').on('input propertychange', function() {
        // jQuery.event.trigger( "ajaxStop" );
        var str = $(this).val();//获取输入框的值
        var pass = $("#loginUser_pass").val(); //第一次密码
        var strLength = $(this).val().length; //获取值的长度
        // console.log(str);
        if(str==""){
            $("#pass_is_repeat").css("color","#ffffff00");
        }else{

            if(str===pass){
                $("#pass_is_repeat").css("color","green");
                $("#pass_is_repeat").removeClass("fa-exclamation-circle").addClass("fa-check-circle");
                passIsSame = true;
            }else{
                $("#pass_is_repeat").css("color","red");
                $("#pass_is_repeat").removeClass("fa-check-circle").addClass("fa-exclamation-circle");
                passIsSame = false;
            }

        }
    });

    function deleteFault(trClicked){
        let id = trClicked.parents("tr").children().eq(1).html();
        console.log(id);
        $.ajax({
            type: "get",
            url: "/deleteUser",
            // dataType: "json"
            data: {"id":id},
            success:function () {

                alert("删除成功");
                $("#default").click();
                location.reload();
            },
            error:function () {
                alert("删除失败！");
            }
        });
    }

    $("#tbody").on("click",".button_delete",function (){
        deleteFault($(this));
    });

});