<%@ page pageEncoding="UTF-8"%>
<div id="main">
    <div class="mt-5">
        <i class="fa-solid fa-pen-to-square fa-2xl"> 게시판 </i>
        <hr>
    </div>

    <div class="row mt-5">
        <div class="row offset-2 col-6">
            <div class="col-3">
                <select class="form-select" id="findtype">
                    <option value="subject">제목</option>
                    <option value="sbjcont">제목+내용</option>
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

                <tr>
                    <td>1</td>
                    <td>석가탄신일·성탄절 대체공휴일 확정</td>
                    <td>운영자</td>
                    <td>2023-05-04</td>
                    <td>175</td>
                    <td>1345</td>
                </tr>

                <tr>
                    <td>1</td>
                    <td>석가탄신일·성탄절 대체공휴일 확정</td>
                    <td>운영자</td>
                    <td>2023-05-04</td>
                    <td>175</td>
                    <td>1345</td>
                </tr>

                <tr>
                    <td>1</td>
                    <td>석가탄신일·성탄절 대체공휴일 확정</td>
                    <td>운영자</td>
                    <td>2023-05-04</td>
                    <td>175</td>
                    <td>1345</td>
                </tr>
                </tbody>

            </table>

        </div>

    </div>

    <div class="row">
        <div class="offset-2 col-8 text-end">
            <nav>
                <ul class="pagination justify-content-center">
                    <li class="page-item disabled"><a class="page-link" href="href=#">이전</a></li>
                    <li class="page-item"><a class="page-link" href="href=#">1</a></li>
                    <li class="page-item"><a class="page-link" href="href=#">2</a></li>
                    <li class="page-item"><a class="page-link" href="href=#">3</a></li>
                    <li class="page-item"><a class="page-link" href="href=#">4</a></li>
                    <li class="page-item"><a class="page-link" href="href=#">5</a></li>
                    <li class="page-item"><a class="page-link" href="href=#">6</a></li>
                    <li class="page-item"><a class="page-link" href="href=#">7</a></li>
                    <li class="page-item"><a class="page-link" href="href=#">8</a></li>
                    <li class="page-item"><a class="page-link" href="href=#">9</a></li>
                    <li class="page-item"><a class="page-link" href="href=#">10</a></li>
                    <li class="page-item disabled"><a class="page-link" href="href=#">다음</a></li>
                </ul>
            </nav>

        </div>

    </div>


</div>
<script src="/assets/js/board.js"></script>
