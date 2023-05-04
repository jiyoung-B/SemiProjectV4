package catgirl.spring4mvc.semiprojectv4.controller;

import catgirl.spring4mvc.semiprojectv4.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService brdsrv;

    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();

        // sungjuklist.jsp에 성적조회결과를 sjs라는 이름으로 넘김
        mv.addObject("board", brdsrv.boardList());
        mv.setViewName("board/list.tiles");
        //mv.setViewName("board/list");

        return mv;
    }

}
