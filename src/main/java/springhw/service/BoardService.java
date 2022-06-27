package springhw.service;

import springhw.domain.BoardRepository;
import springhw.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public boolean save(BoardDto boardDto) {
        int bno = boardRepository.save(boardDto.toentity()).getBno();
        return true;
    }
}
