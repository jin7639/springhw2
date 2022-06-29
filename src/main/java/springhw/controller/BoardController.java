package springhw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springhw.dto.BoardDto;
import springhw.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;
    @Autowired
    private HttpServletRequest request;
    @GetMapping("/save")
    public String save() {
        return "save";
    }
    @PostMapping("/save")
    @ResponseBody   // 템플릿 아닌 객체 반환
    public boolean save(BoardDto boardDto ){
        return boardService.save( boardDto );
    }

    @GetMapping("/")
    public String list() {
        return "list";
    }

    @GetMapping("/getboardlist")
    public void getboardlist(HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application.json");
            response.getWriter().print(boardService.getboardlist());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    @GetMapping("/view/{bno}")
    public String view(@PathVariable("bno") int bno ) {
        request.getSession().setAttribute("bno", bno);
        return "view";
    }
    @GetMapping("/getboard")
    public void getboard(HttpServletResponse response){
        int bno =  (Integer) request.getSession().getAttribute("bno");
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().print(boardService.getboard(bno));
        } catch (IOException e) {
            System.out.println(  e   );
        }
    }
    @GetMapping("/update/{bno}")
    public String update(@PathVariable("bno") int bno ) {
        request.getSession().setAttribute("bno", bno);
        return "update";
    }

    @PutMapping("/update")
    @ResponseBody
    public boolean update(BoardDto boardDto){
        int bno =  (Integer) request.getSession().getAttribute("bno");
        boardDto.setBno(bno);
        return boardService.update(boardDto);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestParam("bno") int bno){
        return boardService.delete(bno);
    }


}
