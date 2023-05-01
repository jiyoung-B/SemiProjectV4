// header 로고 클릭 이벤트
let logo = document.querySelector('#logo');
logo?.addEventListener('click',  () => {
    location.href = '/';
});

// ---------------------------------------------
// 이용약관 체크박스
let agree1 = document.querySelector('#agree1');
// 개인정보 이용 체크박스
let agree2 = document.querySelector('#agree2');

// 동의버튼
let okagree = document.querySelector('#okagree');
okagree?.addEventListener('click', () => {
    if(!agree1.checked) alert("이용약관 동의에 체크하세요!");
    else if(!agree2.checked) alert("개인정보 이용 동의에 체크하세요!")
    else location.href = '/join/checkme';
});

// 미동의버튼
let noagree = document.querySelector('#noagree');
noagree?.addEventListener('click', () => {
    location.href = '/';
});


// --------------------------------------------- checkme
const name2 = document.querySelector('#name2');
const jumin1 = document.querySelector('#jumin1');
const jumin2 = document.querySelector('#jumin2');
const chkjumin = document.querySelector('#chkjumin');
const chk2btn = document.querySelector('#check2btn');
const chkfrm2 = document.querySelector('#checkfrm2');
chk2btn?.addEventListener('click', () => {
    if(name2.value == '') alert('이름을 입력하세요!!');
    else if(jumin1.value == '') alert('주민번호를 입력하세요!!');
    else if(jumin2.value == '') alert('나머지 주민번호를 입력하세요!!');
    else if(!chkjumin.checked) alert('주민번호 처리에 동의하세요!!');
    else {
        chkfrm2.method='post'
        chkfrm2.action='/join/joinme';
        chkfrm2.submit();
    }
});

// --------------------------------------------- joinme
// const name = document.querySelector('#name');
const jumin1a = document.querySelector('#jumin1a');
const jumin2a = document.querySelector('#jumin2a');
const repasswd = document.querySelector('#repasswd');
const userid = document.querySelector('#userid');
const passwd = document.querySelector('#passwd');
const zip1 = document.querySelector('#zip1');
const zip2 = document.querySelector('#zip2');
const addr1 = document.querySelector('#addr1');
const addr2 = document.querySelector('#addr2');
const email1 = document.querySelector('#email1');
const email2 = document.querySelector('#email2');
const tel1 = document.querySelector('#tel1');
const tel2 = document.querySelector('#tel2');
const tel3 = document.querySelector('#tel3');
const grecaptcha = document.querySelector('#g-recaptcha');
const joinbtn = document.querySelector('#joinbtn');

joinbtn?.addEventListener('click', () => {
    if(userid.value == '') alert('아이디를 입력하세요!!')
    else if(passwd.value == '') alert('비밀번호를 입력하세요!!')
    else if(repasswd.value == '') alert('비밀번호를 확인을 입력하세요!!');
    else if(repasswd.value != passwd.value) alert('비밀번호가 서로 일치하지 않아요!!');
    else if(zip1.value == '' || zip2.value == '') alert('우편번호를 확인하세요!!');
    else if(addr1.value == '' || addr2.value == '') alert('주소를 확인하세요!!');
    else if(email1.value == '' || email2.value == '') alert('이메일을 확인하세요!!');
    else if(tel2.value == '' || tel3.value == '') alert('전화번호를 확인하세요!!');
    else if(grecaptcha.value == '') alert('자동가입방지를 확인하세요!!');
    else{
        location.href = '/join/joinok';
    }
});







// --------------------------------------------- joinok
