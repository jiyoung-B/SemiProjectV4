const findtype = document.querySelector("#findtype");
const findkey = document.querySelector("#findkey");
const findbtn = document.querySelector("#findbtn");
findbtn?.addEventListener('click', () => {
    if(findkey.value === '') {alert('검색어를 입력하세요!!'); return;} /*아래코드가 실행되지 않게끔 바로 return*/
    let query = `/board/find?ftype=${findtype.value}&fkey=${findkey.value}&cpg=1`;
    /*let query = `?ftype=${findtype.value}&fkey=${findkey.value}&cpg=1`;*/
    location.href = query;
});