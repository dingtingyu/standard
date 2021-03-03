$(function () {

    $(".menu_content1").hide();

    let url = location.href;
    let strs = url.split("=");
    let thisName = strs[strs.length-1];

    $(".menu_content1").each(function (i,e) {
        console.log($(this).attr("id"));
        let thisId = $(this).attr("id");
        if(thisName === thisId){
            $(this).parent().children('.menu_content1').show();
            $(this).css('background', "#009588");
        }
    });

    $(".main").on("click",".menu_title",function () {
        console.log($(this).attr("class"));
        let children = $(this).parent().children('.menu_content1');
        if (children.css('display') === 'none') {
            children.slideDown(200);
        } else {
            children.slideUp(200);
        }
    });

    $(".main").on("click",".menu_content1",function () {
        if (!$(this).is('.equip')) {
            // $("#content").load("/jumpto?name=" + $(this).attr('id') + "");
            window.location.href="/jumpto?name=" + $(this).attr('id') + "";
        } else {
            $("#thead").html("<tr>\n" +
                "            <th>设备类别</th>\n" +
                "            <th>设备类型</th>\n" +
                "            <th>设备编号</th>\n" +
                "            <th>安装危险区域</th>\n" +
                "            <th>安装位置号</th>\n" +
                "            <th>设备负责人</th>\n" +
                // "            <th>备注</th>\n" +
                // "            <th>操作</th>\n" +
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



});