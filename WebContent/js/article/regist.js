/**
 * 글쓰기 유효성 검사
 */
window.onload = function () {
	document.getElementsByName('subject')[0].focus();
	
	for (var x in document.forms) {
		if (document.forms[x].id == "frmReg") {
			document.forms[x].addEventListener('submit', function(e) {
				e.preventDefault();
				var result = chkRegist(e.target);
				if (result) {
					e.target.submit();
				}
			}, false);
		}
	}
}

function chkRegist(frm){
	
	var span = document.getElementsByTagName("span");
	
	for (var i in span) {
		if (span[i].id == "warning") {
			span[i].innerHTML = "";
		}
	}
	
	for (var y in frm.elements) {
		if (frm.elements[y].value == "" || frm.elements[y].value == null) {
			if (frm.elements[y].name == "subject") {
				frm.elements[y].parentElement.lastElementChild.innerHTML = "글제목은 필수입니다.";
				frm.elements[y].focus();
				return false;
			} 
			if (frm.elements[y].name == "content") {
				frm.elements[y].parentElement.lastElementChild.innerHTML = "내용은 필수입니다.";
				frm.elements[y].focus();
				return false;
			} 
			if (frm.elements[y].name == "passwd") {
				frm.elements[y].parentElement.lastElementChild.innerHTML = "비밀번호는 필수입니다.";
				frm.elements[y].focus();
				return false;
			} 
		} else {
			
		}
	}
	
	return true;
}