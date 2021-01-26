$(function () {

    $("#form_standard").hide();

    let operation = "<td><a class='button_change'>修改</a><a class='button_delete'>删除</a></td>";

    $.ajax({
        type: "post",
        url: "/getgrade",
        dataType: "json",
        success: function (data) {
            console.log("得到的等级："+data);
            if (data > 2) {
                operation = "<td><a class='button_no'>无权限</a></td>"
            }
        }
    });

    //最开始显示车间信息
    $.ajax({
        type: "post",
        url: "/allstandard",
        // url:"",
        dataType: "json",
        success: function (data) {
            console.log(data);
            $("#tbody").empty();
            let htmlStr = "";
            for (let i = 0; i < data.length; i++) {
                // htmlStr = "";
                htmlStr += "<tr>";
                htmlStr += "<td>" + (i + 1) + "</td>td>";
                htmlStr += "<td>" + data[i].gbID + "</td>";
                htmlStr += "<td>" + data[i].gbnum + "</td>";
                htmlStr += "<td>" + data[i].gbsymbol + "</td>";
                htmlStr += "<td>" + data[i].gbinformation + "</td>";
                htmlStr += "<td>" + data[i].gbD + "</td>";
                htmlStr += "<td>" + data[i].gbC + "</td>";
                htmlStr += "<td>" + data[i].gbV + "</td>";
                // htmlStr += "<td>" + data[i].gbcomment + "</td>";
                htmlStr += operation;
                htmlStr += "</tr>";
                // $("#tbody").append(htmlStr);
            }
            $("#tbody").append(htmlStr);
            $(".waiting_img").hide();
        }
    });

    function deleteFault(trClicked){
        let id = trClicked.parents("tr").children().eq(1).html();
        console.log(id);
        $.ajax({
            type: "get",
            url: "/deleteStandard",
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

    $("#tbody").on("click",".button_change",function () {
        let standard = $(this).parents("tr").children();
        let gbID = standard.eq(1).html();
        let gbnum = standard.eq(2).html();
        let gbsymbol = standard.eq(3).html();
        let gbinformation = standard.eq(4).html();
        let gbD = standard.eq(5).html();
        let gbC = standard.eq(6).html();
        let gbV = standard.eq(7).html();
        let gbcomment = standard.eq(8).html();
        let sid = standard.eq(9).html();
        $("#standard_gbId").val(gbID);
        $("#standard_gbnum").val(gbnum);
        $("#standard_gbsymbol").val(gbsymbol);
        $("#standard_information").val(gbinformation);
        $("#standard_gbD").val(gbD);
        $("#standard_gbC").val(gbC);
        $("#standard_gbV").val(gbV);
        $("#standard_comment").val(gbcomment);
        $("#standard_comment").val(sid);
        $(".button_bottom_change").show();
        $(".button_bottom_add").hide();
        $("#form_standard").show();
    })

});
$(".button_bottom_cancel").click(function () {
    $("#form_standard").hide();
    console.log("表格取消");
});