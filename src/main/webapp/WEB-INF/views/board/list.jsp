<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%

    // 게시판 리스트 처리 - 페이징
    // 1. 전체 게시물 수 처리 (bdcnt : 526)
    // 2. 페이지당 보여줄 게시물 수 지정 (=perPage : 10)
    // 3. 총 페이지 수 계산 (=> 52 + 1)
    // 4. 현재 페이지 번호 (cp, )
    // ex) list.do?cp=1 : 526 ~ 517
    // ex) list.do?cp=2 : 516 ~ 507
    // ex) list.do?cp=3 : 506 ~ 497
    // ...
    // ex) list.do?cp=n : x ~ x - 9
    // x를 구하는 식 : (x - 1 ) * 10, (x -1) * 10 -10

%>

<%
    // 게시판 리스트 처리 - 네비게이션
    // 현재 페이지에 따라서 보여줄 페이지 블럭을 결정
    // ex) cp = 1 : 1 2 3 4 5 6 7 8 9 10 다음
    // ex) cp = 3 : 1 2 3 4 5 6 7 8 9 10 다음
    // ex) cp = 9 : 1 2 3 4 5 6 7 8 9 10 다음
    // ex) cp = 11 : 이전 11 12 13 14 15 16 17 18 19 20 다음
    // ex) cp = 15 : 이전 11 12 13 14 15 16 17 18 19 20 다음
    // ex) cp = 23 : 이전 21 22 23 24 25 26 27 28 29 30 다음
    // ex) cp = 52: 이전 51 52 53 54 55
    // startPage = ((cp - 1) / 10) * 10 + 1
    // endPage = startPage + 10 - 1
%>
<div id="main">
    <div class="mt-5">
        <i class="fa-solid fa-pen-to-square fa-2xl"> 게시판 </i>
        <hr>
    </div>

    <div class="row mt-5">
        <div class="row offset-2 col-6">
            <div class="col-3">
                <select class="form-select" id="findtype">
                    <option value="title">제목</option>
                    <option value="titcont">제목+내용</option>
                    <option value="contents">내용</option>
                    <option value="userid">작성자</option>
                </select></div>
            <div class="col-4"><input type="text" class="form-control col-2"></div>
            <div class="col-3">
            <button type="button" class="btn btn-light">
                <i class="fa fa-magnifying-glass"> </i> 검색하기</button></div>
        </div>
        <div class="col-2 text-end">
            <button type="button" class="btn btn-light">
                <i class="fa fa-plus-circle"> </i> 새글쓰기</button>
        </div>
    </div>
    <div class="row mt-2">
        <div class="offset-2 col-8">
            <table class="table table-striped tbborder">
                <thead class="thbg">
                    <tr><th style="width: 7%">번호</th>
                        <th>제목</th>
                        <th style="width: 10%">작성자</th>
                        <th style="width: 10%">작성일</th>
                        <th style="width: 7%">추천</th>
                        <th style="width: 7%">조회</th></tr>
                </thead>

                <tbody>

                <tr>
                    <th>공지</th>
                    <th><span class="badge text-bg-danger">Hot!</span>
                        석가탄신일·성탄절 대체공휴일 확정</th>
                    <th>운영자</th>
                    <th>2023-05-04</th>
                    <th>175</th>
                    <th>1345</th>
                </tr>
                <c:forEach items="${board}" var="bd">
                <tr>
                    <td>${bd.bno}</td>
                    <td>${bd.title}</td>
                    <td>${bd.userid}</td>
                    <td>${fn:substring(bd.regdate, 0, 10)}</td>
                    <td>${bd.thumbs}</td>
                    <td>${bd.views}</td>
                </tr>
                </c:forEach>

                </tbody>

            </table>

        </div>

    </div>



    <c:set var="pglink" value="/board/list?cpg="></c:set>
    <div class="row">
        <div class="offset-2 col-8 text-end">
            <nav>
                <ul class="pagination justify-content-center">

                    <c:if test="${cpg gt 1}">
                        <a class="page-link" href="${pglink}1">처음</a></li>
                    </c:if>
                    <c:if test="${cpg-1 gt 0}"><li class="page-item "></c:if>
                    <c:if test="${cpg-1 le 0}"><li class="page-item disabled"></c:if>
                        <a class="page-link" href="${pglink}${cpg-1}">이전</a></li>
                        <%--// startPage = ((cp - 1) / 10) * 10 + 1
                        // endPage = startPage + 10 - 1--%>
                    <c:forEach var="i" begin="${stpg}" end="${stpg + 10 - 1}">
                        <c:if test="${i le cntpg}">
                        <c:if test="${i ne cpg}"><li class="page-item"></c:if>
                        <c:if test="${i eq cpg}"><li class="page-item active"></c:if>
                        <a class="page-link" href="${pglink}${i}">${i}</a></li>
                        </c:if>

                    </c:forEach>


                            <a class="page-link" href="${pglink}${cpg+1}">다음</a></li>

                        <c:if test="${cpg lt cntpg}">
                    <a class="page-link" href="${pglink}${cntpg}">끝</a></li>
                        </c:if>
                </ul>
            </nav>
        </div>
    </div>








</div>
<script src="/assets/js/board.js"></script>