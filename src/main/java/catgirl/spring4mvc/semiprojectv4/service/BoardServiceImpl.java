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
    public List<Board> boardList(int cpage) {// 현재페이지를 알아야하니 cpage



        int stbno = (cpage -1) * 25; // 25page씩나타넴
        return brddao.selectBoard(stbno);
    }

    @Override
    public int countBoard() {

        return brddao.countBoard();
    }
}
