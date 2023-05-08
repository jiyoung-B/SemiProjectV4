package catgirl.spring4mvc.semiprojectv4.model;

public class Board {
    private int bno;
    private String title;
    private String userid;
    private int thumbs;
    private int views;
    private String content;
    private String regdate;

    public Board() {
    }

    public Board(int bno, String title, String userid, int thumbs, int views, String content, String regdate) {
        this.bno = bno;
        this.title = title;
        this.userid = userid;
        this.thumbs = thumbs;
        this.views = views;
        this.content = content;
        this.regdate = regdate;
    }

    public int getBno() {
        return bno;
    }

    public String getTitle() {
        return title;
    }

    public String getUserid() {
        return userid;
    }

    public int getThumbs() {
        return thumbs;
    }

    public int getViews() {
        return views;
    }

    public String getContent() {
        return content;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setTitle(String 제목입니다) {
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setThumbs(int thumbs) {
        this.thumbs = thumbs;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", userid='" + userid + '\'' +
                ", thumbs=" + thumbs +
                ", views=" + views +
                ", content='" + content + '\'' +
                ", regdate='" + regdate + '\'' +
                '}';
    }


}
