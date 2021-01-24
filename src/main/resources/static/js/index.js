$(function () {
    $(".menu_content").hide();
    $("#head_user_choose_box").hide();
    $("#form_change_user_msg").hide();
    let num = 0;

    //上一个menuContent;
    let lastMenuContent = $("#standard");

    //点击菜单title
    $(".menu_title").click(function () {
        let children = $(this).parent().children('.menu_content');
        if (children.css('display') === 'none') {
            children.slideDown(200);
        } else {
            children.slideUp(200);
        }
    });

    //点击menu content
    $(".menu_content").click(function () {
        lastMenuContent.css('background-color', '#333');
        lastMenuContent = $(this);
        $(this).css('background', "#009588");
        if (!$(this).is('.equip')) {
            $("#content").load("/jumpto?name=" + $(this).attr('id') + "");
        } else {
            $("#thead").html("<tr>\n" +
                "            <th>设备类别</th>\n" +
                "            <th>设备类型</th>\n" +
                "            <th>设备编号</th>\n" +
                "            <th>安装危险区域</th>\n" +
                "            <th>安装位置号</th>\n" +
                "            <th>设备负责人</th>\n" +
                // "            <th>备注</th>\n" +
                "            <th>操作</th>\n" +
                "        </tr>");
            $("#tbody").html("");
            // $(this).css('background', "#009588");
            // $("#content").load("/jumpto?name="+$(this).attr('id')+"");
            let thisId = $(this).attr('id');
            console.log("id:" + thisId);
            $.ajax({
                url: "/getEquipmentByMenuId",
                type: "get",
                data: {id: thisId},
                success: function (data) {
                    replaceData(data);
                }, error: function () {
                    console.log("get data error!");
                }
            });
        }
    });
    $("#standard").parent().children('.menu_content').slideDown();
    $("#standard").click();

    $(".head_left").click(function () {
        $('.left').animate({width: 'toggle'}, 350);
        // console.log("click"+$(".left").css('display'));
        // if($(".left").css('display')==="none"){
        //     $(".left").show(200);
        // }else{
        //     $(".left").hide(200);
        // });
    });

    //头像菜单
    $("#person_msg_button").click(function () {
        console.log("headuser choose box");
        if ($("#head_user_choose_box").css('display') !== 'none') {
            $("#head_user_choose_box").slideUp(200);
        } else {
            $("#head_user_choose_box").slideDown(200);
        }
    });

    $("#button_exit").click(function () {
        $.ajax({
            type: "post",
            url: "/exit",
            success: function () {
                window.location = "/login";
                sessionStorage.clear();
            }, error: function () {
                console.log("exit error!");
            }
        });
    });

    $("#form_change_user_msg").hide();
//修改用户信息
    $("#button_change_personal_msg").click(function () {
        console.log("session:" + sessionStorage.getItem("userName"));
        $("#input_user_name").attr('value', sessionStorage.getItem('userName'));
        $("#form_change_user_msg").show();
    });

    $("#change_user_msg").click(function () {
        $("#form_change_user_msg").hide();
        /*if($(user.getpass)$("#psw_now").val()){

        }*/
        console.log("修改信息")
    })
    $("#cancel_change_user_msg").click(function () {
        $("#form_change_user_msg").hide();
        console.log("表格取消");
    });



    function replaceData(data) {
        let htmlStr = "";
        for (let i = 0; i < data.length; i++) {
            htmlStr += "<tr>";
            // htmlStr += "<td>" + (i + 1) + "</td>td>";
            htmlStr += "<td>" + data[i].testcol + "</td>";
            htmlStr += "<td>" + data[i].testcol0 + "</td>";
            htmlStr += "<td>" + data[i].testcol1 + "</td>";
            htmlStr += "<td>" + data[i].testcol2 + "</td>";
            htmlStr += "<td>" + data[i].testcol3 + "</td>";
            htmlStr += "<td>" + data[i].testcol4 + "</td>";
            // htmlStr += "<td>" + data[i].testcol5 + "</td>";
            htmlStr += "<td><a class='button_agree'>同意</a><a class='button_refuse'>取消</a></td>>";
            htmlStr += "</tr>";
        }
        $("#tbody").html(htmlStr);
    }
});
$("#psw_now").blur(function () {

     if ($("#psw_now").val()!=$("#passwore").val()) {
         alert("与原密码不符");

     }
});


