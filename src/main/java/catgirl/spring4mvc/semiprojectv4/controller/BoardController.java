package catgirl.spring4mvc.semiprojectv4.controller;

import catgirl.spring4mvc.semiprojectv4.model.Board;
import catgirl.spring4mvc.semiprojectv4.service.BoardService;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService brdsrv;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam int cpg){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("board/list.tiles");
        // sungjuklist.jsp에 성적조회결과를 sjs라는 이름으로 넘김
        mv.addObject("board", brdsrv.boardList(cpg));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1); // startPage = ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", brdsrv.countBoard()); // startPage = ((cpg - 1) / 10) * 10 + 1);
        //mv.setViewName("board/list");

        return mv;
    }

    @GetMapping("/find")  // 검색처리 - 매개변수 ftype, fkey 추가
    public ModelAndView find(int cpg, String ftype, String fkey){
        ModelAndView mv = new ModelAndView();
        mv.addObject("board", brdsrv.readBoard(cpg, ftype, fkey));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1); // startPage = ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", brdsrv.countBoard(ftype, fkey)); // startPage = ((cpg - 1) / 10) * 10 + 1);
        mv.setViewName("board/list.tiles");


        return mv;
    }

    @GetMapping("/write")
    public String write(){
        return "board/write.tiles";
    }
    @PostMapping("/write")
    public String writeok(Board bd){
        String viewPage = "error.tiles";
        if(brdsrv.newBoard(bd)){
            viewPage = "redirect:/board/list?cpg=1";
        }
        return viewPage;
    }

    @GetMapping("/view")
    public ModelAndView view(@RequestParam String bno){
        ModelAndView mv = new ModelAndView();
        mv.addObject("bd", brdsrv.readOneBoard(bno));
        mv.setViewName("board/view.tiles");

        return mv;
    }

}
