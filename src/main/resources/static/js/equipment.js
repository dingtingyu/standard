$(function () {
    // $(".menu_content").hide();
    $("#head_user_choose_box").hide();
    $("#form_change_user_msg").hide();
    $("#form_standard").hide();

    $.ajax({
        url: "/equipmentindex",
        type: "get",
        success: function (data) {
            replaceData(data);
        }, error: function () {
            console.log("get data error!");
        }
    });

    // let num = 0;
    //
    // //上一个menuContent;
    // let lastMenuContent = $("#standard");

    // //点击菜单title
    // $(".menu_title").click(function () {
    //     let children = $(this).parent().children('.menu_content');
    //     if (children.css('display') === 'none') {
    //         children.slideDown(200);
    //     } else {
    //         children.slideUp(200);
    //     }
    // });

    //点击menu content
    $(".equip").click(function () {


    });



    //
    // $("#standard").parent().children('.menu_content').slideDown();
    // $("#standard").click();

    // $(".head_left").click(function () {
    //     $('.left').animate({width: 'toggle'}, 350);
    //     // console.log("click"+$(".left").css('display'));
    //     // if($(".left").css('display')==="none"){
    //     //     $(".left").show(200);
    //     // }else{
    //     //     $(".left").hide(200);
    //     // });
    // });

    // //头像菜单
    // $("#person_msg_button").click(function () {
    //     console.log("headuser choose box");
    //     if ($("#head_user_choose_box").css('display') !== 'none') {
    //         $("#head_user_choose_box").slideUp(200);
    //     } else {
    //         $("#head_user_choose_box").slideDown(200);
    //     }
    // });
    //
    // $("#button_exit").click(function () {
    //     $.ajax({
    //         type: "post",
    //         url: "/exit",
    //         success: function () {
    //             window.location = "/login";
    //             sessionStorage.clear();
    //         }, error: function () {
    //             console.log("exit error!");
    //         }
    //     });
    // });

    // $("#form_change_user_msg").hide();
    // $("#button_change_personal_msg").click(function () {
    //     console.log("session:" + sessionStorage.getItem("userName"));
    //     $("#input_user_name").attr('value', sessionStorage.getItem('userName'));
    //     $("#form_change_user_msg").show();
    // });
    //
    // $("#cancel_change_user_msg").click(function () {
    //     $("#form_change_user_msg").hide();
    // });
    //
    //
    // $("#form_standard").hide();
    //
    // $("#li_form_add_work_order").click(function () {
    //     $("#form_standard").show();
    // });
    //
    // $("#cancel_change_user_msg").click(function () {
    //     $("#newmade").hide();
    // });

    //搜索按钮点击
    $("#button_searh").click(function () {
        let content = $("#input_search").val();
        $.ajax({
            url: "/searchEquipmentByName",
            type: "get",
            data: {name: content},
            success:function (data) {
                replaceData(data);
            },error:function () {
                console.error("getDataError");
            }
        });
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
            // htmlStr += "<td><a class='button_agree'>同意</a><a class='button_refuse'>取消</a></td>>";
            htmlStr += "</tr>";
        }
        $("#tbody").html(htmlStr);
    }



});