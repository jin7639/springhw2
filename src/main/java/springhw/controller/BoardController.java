package springhw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/save")
    public String save() {
        return "save";
    }
    @PostMapping("/save")
    @ResponseBody   // 템플릿 아닌 객체 반환
    public boolean save(BoardDto boardDto ){

        return boardService.save( boardDto );
    }
}
