package catgirl.spring4mvc.semiprojectv4.dao;

import catgirl.spring4mvc.semiprojectv4.model.Board;

import java.util.List;

public interface BoardDAO {

    List<Board> selectBoard();

}
