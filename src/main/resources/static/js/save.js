function board_save(){
    alert("save");
    let form = $("#saveform")[0];
    let formdata = new FormData(form);
     $.ajax({
        url: '/save',
        data : formdata,
        method : 'POST',
        processData : false,
        contentType: false,
        success : function(result){
            alert(result);
        }
    });
}