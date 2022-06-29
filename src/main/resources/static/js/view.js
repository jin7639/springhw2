board_get();
function board_get(){
    $.ajax({
        url: '/getboard',
        success : function(board){
            let html =
                ' <div>게시물 번호 : '+board.bno+' </div>'+
                 '<div>게시물 제목 : '+board.btitle+'</div>'+
                 '<div>게시물 내용 : '+board.bcontent+'</div>'+
                 '<button><a href="/update/'+board.bno+'">수정<a></button>'+
                 '<button onclick="board_delete('+board.bno+')"> 삭제 </button>';
            $("#boarddiv").html(html);
        }
    });
}

function board_delete(bno){
    $.ajax({
            url: '/delete',
            data : {"bno" : bno},
            method : 'delete',
            success : function(result){
                alert("삭제되었습니다.");
                location.href = "/";
            }
        });
}