board_list();

function board_list(){
    $.ajax({
        url: '/getboardlist',
        method : 'GET',
        success : function(boardlist){
            let html = $("#boardtable").html();
            for (let i = 0; i < boardlist.length; i++){
                html +=
                 '<tr>'+
                     '<td>'+boardlist[i].bno+'</td> '+
                     '<td><a href="/view/'+boardlist[i].bno+'">'+boardlist[i].btitle+'<a></td> '+
                  '</tr>';
            }
            $("#boardtable").html(html);
        }
    });
}

