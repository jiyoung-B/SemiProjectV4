package catgirl.spring4mvc.semiprojectv4.dao;

import catgirl.spring4mvc.semiprojectv4.model.Board;
import catgirl.spring4mvc.semiprojectv4.model.Member;

import java.util.List;

public interface MemberDAO {
    int selectLogin(Member m);
}
