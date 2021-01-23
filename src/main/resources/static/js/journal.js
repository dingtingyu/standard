$(function () {

    $.ajax({
        url:"/getallJournal",
        type:"get",
        success:function (data) {
            replaceData(data);
        },error:function () {
            console.error("get journal error!");
        }
    });

    function replaceData(data) {
        let htmlStr = "";
        for (let i = 0; i < data.length; i++) {
            htmlStr += "<tr>";
            htmlStr += "<td>" + (i + 1) + "</td>";
            htmlStr += "<td>" + data[i].username + "</td>";
            htmlStr += "<td>" + data[i].ipAddress + "</td>";
            htmlStr += "<td>" + data[i].date + "</td>";
            //htmlStr += "<td>" + "17:00:10" + "</td>";

            console.log(rTime(data[i].date),data[i].date);
            htmlStr += "<td>" + data[i].operation + "</td>";
            // htmlStr += "<td>" + data[i].testcol5 + "</td>";
            // htmlStr += "<td><a class='button_agree'>同意</a><a class='button_refuse'>取消</a></td>>";
            htmlStr += "</tr>";
        }
        $("#tbody").html(htmlStr);
    }

    console.log(getdate(new Date()));

    function rTime(date) {
        var json_date = new Date(date).toJSON();
        return new Date(new Date(json_date) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
    }

});