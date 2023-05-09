import catgirl.spring4mvc.semiprojectv4.model.Board;
import catgirl.spring4mvc.semiprojectv4.model.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml"})
public class BoardDAOTest {

    @Autowired
    SqlSession sqlSession;


    @Test
    public void selectBoard() {
        assertNotNull(sqlSession.selectList("board.selectBoard"));
    }

    @Test
    public void selectFindBoard(){
        Map<String, Object> params = new HashMap<>();
        params.put("stbno", 0);
        //params.put("stbno", "title");
        params.put("ftype", "titcont");
        params.put("fkey", "석가");

        assertNotNull(sqlSession.selectList("board.selectFindBoard", params));
        System.out.println((sqlSession.selectList("board.selectFindBoard", params)));
    }

    @Test
    public void countFindBoard(){
        Map<String, Object> params = new HashMap<>();

        params.put("ftype", "titcont");
        params.put("fkey", "석가");

        assertNotEquals(0, (int)sqlSession.selectOne("board.countFindBoard", params));
        System.out.println((int)(sqlSession.selectOne("board.countFindBoard", params)));
    }

    @Test
    public void insertBoard(){
        Board bd = new Board();
        bd.setTitle("제목입니다");
        bd.setUserid("abc123");
        bd.setContent("본문입니다.");
        assertEquals(1, (int)sqlSession.insert("board.insertBoard", bd));
        System.out.println(sqlSession.insert("board.insertBoard", bd));

    }
    @Test
    public void selectOneBoard() {

        assertNotNull(sqlSession.selectOne("board.selectOneBoard"), "123");
    }


}
