package catgirl.spring4mvc.semiprojectv4.service;

import catgirl.spring4mvc.semiprojectv4.dao.BoardDAO;
import catgirl.spring4mvc.semiprojectv4.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("brdsrv")
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardDAO brddao;
    @Override
    public List<Board> boardList() {


        return brddao.selectBoard();
    }
}
