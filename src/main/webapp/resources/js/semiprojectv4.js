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
const chkfrm2 = document.forms.checkfrm2;
const chk2btn = document.querySelector('#check2btn');
chk2btn?.addEventListener('click', () => {
    if(chkfrm2.name2.value === '') alert('이름을 입력하세요!!');
    else if(chkfrm2.jumin1.value === '') alert('주민번호를 입력하세요!!');
    else if(chkfrm2.jumin2.value === '') alert('나머지 주민번호를 입력하세요!!');
    else if(!chkfrm2.chkjumin.checked) alert('주민번호 처리에 동의하세요!!');
    else {
        chkfrm2.method='post'
        chkfrm2.action='/join/joinme';
        chkfrm2.submit();
    }
});

// --------------------------------------------- joinme
const joinfrm = document.forms.joinfrm;
const joinbtn = document.querySelector('#joinbtn');
const dong  = document.querySelector('#dong');
const zipbtn = document.querySelector('#findzipbtn');
const addrlist = document.querySelector('#addrlist');
const sendzip = document.querySelector('#sendzip');
const zipmodal = document.querySelector('#zipmodal');
const zpmdbtn = document.querySelector('#zpmdbtn');
const email3 = document.querySelector('#email3');
const userid = document.querySelector('#userid');
const uidmsg = document.querySelector('#uidmsg');
const pwdmsg = document.querySelector('#pwdmsg');


const modal = new bootstrap.Modal(zipmodal, {});

joinbtn?.addEventListener('click', () => {
    if(joinfrm.userid.value == '') alert('아이디를 입력하세요!!')
    else if(joinfrm.passwd.value == '') alert('비밀번호를 입력하세요!!')
    else if(joinfrm.repasswd.value == '') alert('비밀번호를 확인을 입력하세요!!');
    else if(joinfrm.repasswd.value != joinfrm.passwd.value) alert('비밀번호가 서로 일치하지 않아요!!');
    else if(joinfrm.zip1.value == '' || joinfrm.zip2.value == '') alert('우편번호를 확인하세요!!');
    else if(joinfrm.addr1.value == '' || joinfrm.addr2.value == '') alert('주소를 확인하세요!!');
    else if(joinfrm.email1.value == '' || joinfrm.email2.value == '') alert('이메일을 확인하세요!!');
    else if(joinfrm.tel2.value == '' || joinfrm.tel3.value == '') alert('전화번호를 확인하세요!!');
    else if(grecaptcha.getResponse() === '') alert('자동가입방지를 확인하세요!!');
    else{
        joinfrm.method = 'post';
        joinfrm.action = '/join/joinok';
        joinfrm.submit();
    }
});
zpmdbtn?.addEventListener('click', () => {
    while (addrlist.lastChild) {
        addrlist.removeChild(addrlist.lastChild);
    }

    dong.value = '';
    modal.show();
});

const showzipaddr = (jsons) => {
    //console.log(jsons)
    // for(idx in jsons){
    //     console.log(jsons[idx]);
    // }
    jsons = JSON.parse(jsons);
    let addrs = '';
    jsons.forEach(function (data, idx) {
        let bunji = (data['bunji'] !== null) ? data['bunji'] : '';
        addrs += `<option>${data['zipcode']} ${data['sido']} ${data['gugun']} ${data['dong']} ${bunji}</option>`;
    });
    while (addrlist.lastChild) {
        addrlist.removeChild(addrlist.lastChild);
    }
    addrlist.innerHTML = addrs;
};
zipbtn?.addEventListener('click', () => {
    if(dong.value === ''){
        alert('검색할 동이름을 입력하세요!!');
        return;
    }
    const url = '/join/zipcode?dong=' + dong.value;
    fetch(url).then(response => response.text())
        .then(text => showzipaddr(text));
});
sendzip?.addEventListener('click', () => {
    let addr = addrlist.value;
    if(addr !== ''){
        // 123-456 서울 구로구 구로1동
        let zip = addr.split(' ')[0]; // 123-456
        joinfrm.zip1.value = zip.split('-')[0];
        joinfrm.zip2.value = zip.split('-')[1];
        let addrs = `${addr.split(' ')[1]}${addr.split(' ')[2]} ${addr.split(' ')[3]}`;
        joinfrm.addr1.value = addrs;
        bootstrap.Modal.getInstance(zipmodal).hide();


    }else {
        alert('주소를 선택하세요!!')
    }
});

email3?.addEventListener('change', () => {
    if (email3.value === '직접입력하기'){
        joinfrm.email2.readOnly = false;
        joinfrm.email2.value = '';
    }else if(email3.value !== '선택하세요'){
        joinfrm.email2.readOnly = true;
        joinfrm.email2.value = email3.value;

    }
});
dong?.addEventListener('keydown', () => {
    if(e.keyCode === 13){ // 엔터키를 누르면
        e.preventDefault(); // 이벤트 전파방지
    }
})
userid?.addEventListener('blur', () =>{
    if(userid.value === ''){
        alert('중복 검색할 아이디를 입력하세요!!');
        return;
    }
    const url = '/join/checkuid?uid=' + userid.value;
    fetch(url).then(response => response.text())
        .then(text => alert(text));

})





// --------------------------------------------- joinok
