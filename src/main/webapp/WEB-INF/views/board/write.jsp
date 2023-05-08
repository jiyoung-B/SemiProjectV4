<%@ page pageEncoding="UTF-8"%>
<div id="main">
<script src = "https://www.google.com/recaptcha/api.js"></script>
    <div class="mt-5">
        <i class="fa-solid fa-pen-to-square fa-2xl"> 게시판 </i>
        <hr>
    </div>

    <div class="row mt-5">
        <div class="row offset-2 col-4">
            <h4><i class="fa fa-plus-circle"></i> 새글쓰기</h4>
        </div>
        <div class="col-4 text-end">
            <button type="button" class="btn btn-light">
                <i class="fa fa-list"></i> 목록으로
            </button>
        </div>

        <div class="row mt-2 offset-2 col-8">
            <form class="card card-body bg-light" name="bdfrm" id="bdfrm">
                <div class="row">
                    <label class="col-3 col-form-label text-danger text-end" for="title">제목</label>
                    <div class="col-6">
                        <input type="text" name="title" id="title" class="form-control border-danger">
                    </div>
                </div>
                <div class="row mt-2">
                    <label class="col-3 col-form-label text-danger text-end" for="userid">작성자</label>
                    <div class="col-6">
                        <input type="text" name="userid" id="userid" readonly
                               class="form-control border-danger bg-light" value="abc123">
                    </div>
                </div>
                <div class="row mt-2">
                    <label class="col-3 col-form-label text-danger text-end" for="content">본문</label>
                    <div class="col-6">
                        <textarea type="text" name="content" id="content" rows="15"
                                  class="form-control border-danger" ></textarea>
                    </div>
                </div>
                <div class="row mt-2">
                    <label class="col-3 col-form-label text-danger text-end" for="g-recaptcha">자동가입방지</label>
                    <div class="col-6">
                        <div class="g-recaptcha" data-sitekey="6LdJ4OskAAAAADNIADK7jJrjeVgeG9Y9mP3bx_V_"></div>
                        <input type="hidden" name="grecaptcha" id="g-recaptcha">
                    </div>
                </div>
                <div class="row mt-4 justify-content-center">
                    <hr class="w-75">
                    <div class="text-center">
                        <button type="button" id="writebtn" class="btn btn-primary">
                        <i class="fa fa-check">입력완료</i>
                    </button>
                        <button type="button" id="canclebtn" class="btn btn-danger">
                        <i class="fa fa-remove">입력취소</i>
                    </button>
                    </div>
                </div>

            </form>
        </div>

    </div>

</div>
<script src="/assets/js/board.js"></script>