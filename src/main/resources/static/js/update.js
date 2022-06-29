
function board_update(){
    let form = $("#updateform")[0];
    let formdata = new FormData(form);
    $.ajax({
            url: '/update',
            data : formdata,
            method : 'PUT',
            processData : false,
            contentType: false,
            success : function(result){
                location.href = "/";
            }
        });
}
