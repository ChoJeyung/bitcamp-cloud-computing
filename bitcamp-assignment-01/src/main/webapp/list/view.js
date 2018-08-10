"use strict"

var data = null;
var {name, page, size} = $.parseQuery(location.href);

console.log(name);
if (name == undefined) { // 입력 폼
    $('.viewform').css('display', 'none');
    $(eName).removeAttr("readonly");
    
} else { // 상세 보기 폼
    $('.newform').css('display', 'none');

    $.getJSON(serverApiAddr + `/json/namecard/view/${name}`, 
        function(result) {
            data = result;
            console.log(data.namecard);
            if (data.namecard == null) {
                alert('아이디가 무효합니다.');
                location.href = "list.html";
                return;
            }
            $(eName).val(data.namecard.name);
            $(eEmail).val(data.namecard.email);
            $(eCellphone).val(data.namecard.cellphonenum);
            $(ePhone).val(data.namecard.phonenum);
            $(eFax).val(data.namecard.faxnum);
            $(eMemo).val(data.namecard.memo);
    });
}

$(eListBtn).click(function() {
    if (page) {
        location.href = `list.html?page=${page}&size=${size}`;
    } else {
        location.href = 'list.html';
    }
});

$(eUpdateBtn).click(function() {
    $.post(serverApiAddr + '/json/namecard/update', 
        {
            name: $(eName).val(), 
            email: $(eEmail).val(), 
            cellphonenum: $(eCellphone).val(),
            phonenum: $(ePhone).val(),
            faxnum: $(eFax).val(),
            memo: $(eMemo).val()
        },
        function(data) {
            if (data.status == 'success') {
                location.href = `list.html?page=${page}&size=${size}`;
            } else {
                alert('변경 오류입니다!');
                console.log(data.error);
            }
        },
        'json');
});

$(eDeleteBtn).click(function() {
    $.getJSON(serverApiAddr + `/json/namecard/delete?name=${eName.value}`, 
        function(data) {
            if (data.status == 'success') {
                location.href = `list.html?page=${page}&size=${size}`;
            } else {
                alert('삭제 오류입니다!');
                console.log(data.error);
            }
    });
});

$(eAddBtn).click(function() {
    $.post(serverApiAddr + '/json/namecard/add', 
        {
        name: $(eName).val(), 
        email: $(eEmail).val(), 
        cellphonenum: $(eCellphone).val(),
        phoneNum: $(ePhone).val(),
        faxnum: $(eFax).val(),
        memo: $(eMemo).val()
        },
        function(data) {
            location.href = 'list.html';
        },
        'json');
});
    