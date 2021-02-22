// 입력 데이터의 길이 체크(~자 이상) - obj - input tag 개체
// if(!checkLength(input객체, "항목이름", 길이)) return false;
function checkLength(obj, item, len){
	if(obj.val().length < len){ 
		// 경고
		alert(item + "은(는) " + len + "자 이상이여야 합니다.");
		//만약에 타입이 패스워드인 경우 사용자 눈에 안보이므로 데이터를 제거한다.
		if(obj.type == "password") {
			
			obj.val() = "";		// Error : invalid assignment target
			
		} 
			
		// 커서를 위치시킨다.
		obj.focus();
		
		// submit()을 취소시키기 위한 false를 리턴한다.
		return false;
		
	}
	// 데이터가 적당하면 true를 리턴한다.
	
	return true;
	
}