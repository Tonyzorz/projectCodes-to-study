//mainPage session function
$(document).ready(function() {
	if ($('#sessionId').val()==""||$('#sessionId').val()==null) {
		$('#logoutPart').hide();
	} else {
		$('#loginPart').hide();
	}
});


//button functions
function goLogin(){
	location.href="login";
};
function goLogout(){
	location.href="logout";
};
function goSignup(){
	location.href="signup"
};

function goJMainBoard(){
	location.href="jMainBoard";
};

function goReply(){
	location.href="jReplyBoard"
};

//회원가입 정규식


function check() {
	var id = document.getElementById("userId");
	var pw = document.getElementById("userPw");
	var tel = document.getElementById("userPhoneNum");

	if(!chk( /^[A-Za-z0-9]{4,20}$/, id, "ID는 최소 4자리 이상 20자리 이하 대/소문자 및 숫자 형식만 지원됩니다."))
		return false;
	if(!chk( /^[A-Za-z0-9]{6,12}$/, pw, "비밀번호는 최소 6자리 이상 12자리 이하 대/소문자 및 숫자 형식만 지원됩니다."))
		return false;
	if(!chk(/^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/, tel, "올바른 휴대전화 형식이 아닙니다."))
		return false;
}

function chk(re, e, msg) {
	if(re.test(e.value)){
		return true;
	}
	alert(msg);
	e.value="";
	e.focus();
	return false;
}
function pwchk(e1, e2, msg) {
	if(e1.value == e2.value){
		return true;
	}
	alert(msg);
	e2.value="";
	e2.focus();
	return false;
}


////////////////////////////
//$(function(){
//    nhn.husky.EZCreator.createInIFrame({
//        oAppRef: oEditors,
//        elPlaceHolder: "ir1", //textarea에서 지정한 id와 일치해야 합니다. 
//        //SmartEditor2Skin.html 파일이 존재하는 경로
//        sSkinURI: "/smarteditor/smarteditor2-master/dist/SmartEditor2Skin.html",  
//        htParams : {
//            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
//            bUseToolbar : true,             
//            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
//            bUseVerticalResizer : true,     
//            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
//            bUseModeChanger : true,         
//            fOnBeforeUnload : function(){
//                 
//            }
//        }, 
//        fOnAppLoad : function(){
//            //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
//            oEditors.getById["ir1"].exec("PASTE_HTML", ["기존 DB에 저장된 내용을 에디터에 적용할 문구"]);
//        },
//        fCreator: "createSEditor2"
//    });
//    
//    //저장버튼 클릭시 form 전송
//    $("#save").click(function(){
//        oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
//        $("#frm").submit();
//    });    
//});
