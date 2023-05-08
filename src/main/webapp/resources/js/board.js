const findtype = document.querySelector("#findtype");
const findkey = document.querySelector("#findkey");
const findbtn = document.querySelector("#findbtn");
findbtn?.addEventListener('click', () => {
    let query = `/board/find?ftype=${findtype.value}&fkey=${findkey.value}&cpg=1`;
    /*let query = `?ftype=${findtype.value}&fkey=${findkey.value}&cpg=1`;*/
    location.href = query;
});