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


});