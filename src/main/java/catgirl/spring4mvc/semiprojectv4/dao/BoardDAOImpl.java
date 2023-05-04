package catgirl.spring4mvc.semiprojectv4.dao;

import catgirl.spring4mvc.semiprojectv4.model.Board;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("brddao")
public class BoardDAOImpl implements BoardDAO{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public List<Board> selectBoard() {

        return sqlSession.selectList("board.selectBoard");
    }
}
