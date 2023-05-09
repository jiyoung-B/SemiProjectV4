package catgirl.spring4mvc.semiprojectv4.service;

import catgirl.spring4mvc.semiprojectv4.model.Board;

import java.util.List;

public interface BoardService {
    List<Board> boardList(int cpage);
    List<Board> readBoard(int cpage, String ftype, String fkey);

    int countBoard();
    int countBoard(String ftype, String fkey);

    boolean newBoard(Board bd);

    Board readOneBoard(String bno);

}
