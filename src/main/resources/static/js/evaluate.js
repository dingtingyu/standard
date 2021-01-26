$(function () {

    $("#form_evaluate").hide();

    let operation = "<td><a class='button_change'>修改</a><a class='button_delete'>删除</a></td>";

    $("#li_form_add_evaluate").click(function () {
        $(".button_bottom_change").hide();
        $(".button_bottom_add").show();
        $("#form_evaluate").show();
    });

    $(".button_bottom_cancel").click(function () {
        console.log("cancel");
        $(this).parent().parent().hide();
    });

    $(".button_bottom_add").click(function () {
        addevaluate();
    });



    $.ajax({
        type: "get",
        url: "/allknowledegeBase",
        // url:"",
        dataType: "json",

        success: function (data) {
            //alert("1");
            console.log(data);
            $("#tbody").empty();
            let htmlStr = "";
            for (let i = 0; i < data.length; i++) {
                // htmlStr = "";
                htmlStr += "<tr>";
                htmlStr += "<td>" + (i + 1) + "</td>td>";
                htmlStr += "<td>" + data[i].devicename + "</td>";
                htmlStr += "<td>" + data[i].location + "</td>";
                htmlStr += "<td>" + data[i].device_id + "</td>";
                htmlStr += "<td>" + data[i].problem_types + "</td>";
                htmlStr += "<td>" + data[i].problem_description + "</td>";
                htmlStr += "<td>" + data[i].suggestion + "</td>";

                //htmlStr += "<td><img src='"+data[i].picture+"' alt=''></td>";
                //htmlStr += "<td>" + data[i].picture + "</td>";
                htmlStr += "<td><a class='button_change'>修改</a><a class='button_delete'>删除</a></td>>"
                //htmlStr += operation;
                htmlStr += "</tr>";
                // $("#tbody").append(htmlStr);
            }
            $("#tbody").append(htmlStr);
            //$(".waiting_img").hide();
        },
        error:function(data) {
            console.log(data);
            // alert('er');
            alert("无！");
            //window.location.href="allList.html";
        }
    });

    $("#selectbyname").click(function () {
        selectbyname();
    });
    function selectbyname() {

        var nameValue=$("#devicename").val();
        if(nameValue===''){
            alert("请输入设备名称！");
            window.location.href="index";
        }
        else $.ajax({
            type: "get",
            url: "/knowledegeBasebyname",
            // url:"",
            dataType: "json",
            data: {"devicename":nameValue},

            success: function (data) {
                if(data.length === 0){
                    alert("无此类信息！");
                    window.location.href="index";
                }
                else {
                alert("查询成功");
                console.log(data);
                $("#tbody").empty();
                let htmlStr = "";
                for (let i = 0; i < data.length; i++) {
                    // htmlStr = "";
                    htmlStr += "<tr>";
                    htmlStr += "<td>" + (i + 1) + "</td>td>";
                    htmlStr += "<td>" + data[i].devicename + "</td>";
                    htmlStr += "<td>" + data[i].location + "</td>";
                    htmlStr += "<td>" + data[i].device_id + "</td>";
                    htmlStr += "<td>" + data[i].problem_types + "</td>";
                    htmlStr += "<td>" + data[i].problem_description + "</td>";
                    htmlStr += "<td>" + data[i].suggestion + "</td>";

                    htmlStr += "<td><a class='button_change'>修改</a><a class='button_delete'>删除</a></td>>"
                    htmlStr += "</tr>";
                }
                $("#tbody").append(htmlStr);
            }
                },
            error:function(data) {
                console.log(data);
                // alert('er');
                alert("错误！");
                //window.location.href="allList.html";
            }
        });
    }
    function deleteFault(trClicked){
        let id = trClicked.parents("tr").children().eq(3).html();
        console.log(id);
        $.ajax({
            type: "get",
            url: "/deleteKnowledge",
            // dataType: "json"
            data: {"deviceId":id},
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

    $("#tbody").on("click",".button_change",function () {
    let knowledgebase = $(this).parents("tr").children();
    let devicename = knowledgebase.eq(1).html();
    let location = knowledgebase.eq(2).html();
    let device_id = knowledgebase.eq(3).html();
    let problem_types = knowledgebase.eq(4).html();
    let problem_description = knowledgebase.eq(5).html();
    let suggestion = knowledgebase.eq(6).html();
    $("#knowledgebase_devicename").val(devicename);
    $("#knowledgebase_location").val(location);
    $("#knowledgebase_device_id").val(device_id);
    $("#knowledgebase_problem_types").val(problem_types);
    $("#knowledgebase_problem_description").val(problem_description);
    $("#knowledgebase_suggestion").val(suggestion);
    $(".button_bottom_change").show();
    $(".button_bottom_add").hide();
    $("#form_knowledgebase").show();
    })
});

$(".button_bottom_cancel").click(function () {
    $("#form_standard").hide();
    console.log("表格取消");
});