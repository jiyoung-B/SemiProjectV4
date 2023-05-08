package catgirl.spring4mvc.semiprojectv4.dao;

import catgirl.spring4mvc.semiprojectv4.model.Board;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("brddao")
public class BoardDAOImpl implements BoardDAO{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public List<Board> selectBoard(int stbno) {

        return sqlSession.selectList("board.selectBoard", stbno);
    }

    @Override
    //public List<Board> selectBoard(int stbno, String ftype, String fkey) {
    public List<Board> selectBoard(Map<String, Object> params) {
        return sqlSession.selectList("board.selectFindBoard", params);
    }

    @Override
    public int countBoard() {
        return sqlSession.selectOne("board.countBoard");

    }

    @Override
    //public int countBoard(int stbno, String ftype, String fkey) {
    public int countBoard(Map<String, Object> params) {
        return sqlSession.selectOne("board.countFindBoard", params);
    }
}
