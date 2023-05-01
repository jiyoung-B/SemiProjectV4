package catgirl.spring4mvc.semiprojectv4.controller;

import catgirl.spring4mvc.semiprojectv4.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/join")
public class JoinController {

    @GetMapping("/agree")
    public String agree(){
        return "join/agree.tiles";

    }

    @GetMapping("/checkme")
    public String checkme(){
        return "join/checkme.tiles";
    }

    @PostMapping("/joinme")
    public ModelAndView joinme(Member mb){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("join/joinme.tiles");
        mv.addObject("mb", mb);
        return mv;

    }
    @GetMapping("/joinok")
    public String joinok2(){
        return "join/joinok.tiles";

    }
    @PostMapping("/joinok")
    public ModelAndView joinok(Member mb){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("join/joinok.tiles");
        mv.addObject("mb", mb);
        return mv;

    }
}
