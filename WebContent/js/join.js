/**
 * 회원가입 관련 자바스크립트 처리
 * @author 이대용
 */

window.onload = function () {
	
	var elements = document.forms[0].elements;

	for (var x in elements) {
		if (elements[x].type == 'submit') {
			elements[x].addEventListener('click', function(e) {
				e.preventDefault();
				
				// 유효성 체크
				if(chk()) {
					document.forms[0].submit();
				}
				
			}, false);
		}
	}
}

/**
 * 유효성 검사
 * @returns
 */
function chk() {
	var id        = document.getElementsByName('id')[0].value;
	var passwd    = document.getElementsByName('passwd')[0].value;
	var name      = document.getElementsByName('name')[0].value;
	var email     = document.getElementsByName('email')[0].value;
	var telephone = document.getElementsByName('telephone')[0].value;
	
	// ID 유효성 검사 (4~8자) 
	var idReg = /^[a-z0-9_]{4,8}$/i;
	if (!idReg.test(id)) {
		document.getElementsByName('id')[0].focus();
		document.getElementsByName('id')[0].parentElement.lastElementChild.innerHTML = "check your ID (min: 4, max: 8 word)";
		return false;
	} else {
		document.getElementsByName('id')[0].parentElement.lastElementChild.innerHTML = "";
	}
	
	// PASSWORD 유효성 검사(4~8자)
	var passwdReg = /^[a-z0-9_]{4,8}$/i;
	if (!passwdReg.test(passwd)) {
		document.getElementsByName('passwd')[0].focus();
		document.getElementsByName('passwd')[0].parentElement.lastElementChild.innerHTML = "check your PASSWORD(min: 4, max: 8 word)";
		return false;
	} else {
		document.getElementsByName('passwd')[0].parentElement.lastElementChild.innerHTML = "";
	}

	// NAME 유효성 검사(2~20자)
	var nameReg = /^[\w\Wㄱ-ㅎㅏ-ㅣ가-힣]{2,20}$/;
	if (!nameReg.test(name)) {
		document.getElementsByName('name')[0].focus();
		document.getElementsByName('name')[0].parentElement.lastElementChild.innerHTML = "check your NAME(min: 2, max: 20 word)";
		return false;
	} else {
		document.getElementsByName('name')[0].parentElement.lastElementChild.innerHTML = "";
	}

	// EMAIL 유효성 검사
	var emailReg = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	if (!emailReg.test(email)) {
		document.getElementsByName('email')[0].focus();
		document.getElementsByName('email')[0].parentElement.lastElementChild.innerHTML = "check your EMAIL";
		return false;
	} else {
		document.getElementsByName('email')[0].parentElement.lastElementChild.innerHTML = "";
	}
	
	// TELEPHONE 유효성 검사
	var telReg = /^\d{3}-\d{3,4}-\d{4}$/;
	if (!telReg.test(telephone)) {
		document.getElementsByName('telephone')[0].focus();
		document.getElementsByName('telephone')[0].parentElement.lastElementChild.innerHTML = "check your TELEPHONE";
		return false;
	} else {
		document.getElementsByName('telephone')[0].parentElement.lastElementChild.innerHTML = "";
	}
	
	return true;
}