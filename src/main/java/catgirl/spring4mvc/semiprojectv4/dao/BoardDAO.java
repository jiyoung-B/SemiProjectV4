package catgirl.spring4mvc.semiprojectv4.dao;

import catgirl.spring4mvc.semiprojectv4.model.Board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {

    List<Board> selectBoard(int stbno);
    List<Board> selectBoard(Map<String, Object> params);
   // List<Board> selectBoard(int stbno, String ftype, String fkey);

    int countBoard();
    int countBoard(Map<String, Object> params);
    //int countBoard(int stbno, String ftype, String fkey);

}
