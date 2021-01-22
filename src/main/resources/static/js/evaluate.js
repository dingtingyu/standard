$(function () {

    $("#form_evaluate").hide();

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
        type: "post",
        url: "http://192.168.2.171:8282/allknowledegeBase",
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
                htmlStr += "<td>" + data[i].remark + "</td>";
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
    function addevaluate(){
        let devicename = $("#evaluate_name").val();
        let location = $("#evaluate_loc").val();
        let device_id = $("#evaluate_Id").val();
        let problem_types = $("#evaluate_type").val();
        let problem_description = $("#evaluate_dis").val();
        let suggestion = $("#evaluate_sug").val();
        let remark = $("#evaluate_re").val();
        $.ajax({
            type: "post",
            url: "http://192.168.2.171:8282/addknowledegeBase",
            // url:"",
            dataType: "json",
            data: {devicename:devicename,location:location,device_id:device_id,problem_types:problem_types,problem_description:problem_description,suggestion:suggestion,remark:remark},
            success: function () {
                $("#form_evaluate").hide();
                alert("添加成功！");
                window.location.href="evaluate.html";
            },error:function () {
                $("#form_evaluate").hide();
                alert("添加成功！");
                window.location.href="evaluate.html";
            }
        });
    }

    $("#selectbyname").click(function () {
        selectbyname();
    });
    function selectbyname() {

        var nameValue=$("#devicename").val();
        if(nameValue===''){
            alert("请输入设备名称！");
            window.location.href="evaluate.html";
        }
        else $.ajax({
            type: "post",
            url: "http://192.168.2.171:8282/knowledegeBasebyname",
            // url:"",
            dataType: "json",
            data: {"devicename":nameValue},

            success: function (data) {
                if(data.length === 0){
                    alert("无此类信息！");
                    window.location.href="evaluate.html";
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
                    htmlStr += "<td>" + data[i].remark + "</td>";
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
});