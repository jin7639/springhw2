package springhw.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.transaction.annotation.Transactional;
import springhw.domain.BoardEntity;
import springhw.domain.BoardRepository;
import springhw.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public boolean save(BoardDto boardDto) {
        System.out.println("save");
        boardRepository.save(boardDto.toentity());
        return true;
    }

    public JSONArray getboardlist() {
        JSONArray jsonArray = new JSONArray();
        List<BoardEntity> boardEntities = boardRepository.findAll();
        for (BoardEntity entity : boardEntities){
            JSONObject object = new JSONObject();
            object.put("bno",entity.getBno());
            object.put("btitle",entity.getBtitle());
            jsonArray.put(object);
        }

        return jsonArray;
    }

    public JSONObject getboard( int bno ){
        Optional<BoardEntity> optional =  boardRepository.findById( bno );
        BoardEntity entity = optional.get();
        JSONObject object = new JSONObject();
        object.put("bno" , entity.getBno() );
        object.put("btitle" , entity.getBtitle() );
        object.put("bcontent" , entity.getBcontent() );
        return object;
    }

    @Transactional
    public boolean update(BoardDto boardDto ){
        Optional<BoardEntity> optionalBoard = boardRepository.findById(boardDto.getBno());
        BoardEntity boardEntity = optionalBoard.get();
        boardEntity.setBtitle(boardDto.getBtitle());
        boardEntity.setBcontent(boardDto.getBcontent());
        return true;
    }

    @Transactional
    public boolean delete(int bno) {
        BoardEntity boardEntity = boardRepository.findById(bno).get();
        boardRepository.delete(boardEntity);
        return true;
    }
}
