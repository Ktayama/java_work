function DeleteCheck() {
	
	var userDeletePass = document.form.userDeletePass.value;
	var userPassDeleteCheck = document.form.userPassDeleteCheck.value;
	var userPassCheckAnswer = document.form.userPassCheckAnswer.value;
	
	if (form.userDeletePass.value == "") {
		alert("パスワードを入力してください");//エラーメッセージを出力
		return false; //送信ボタン本来の動作をキャンセルします
	} else if (!form.userDeletePass.value.match(/^([a-zA-Z0-9]{8,})$/)) {
		alert("パスワードは半角英数字で8文字以上に設定してください"); //エラーメッセージを出力
		return false;//送信ボタン本来の動作をキャンセルします
	} else if (form.userPassDeleteCheck.value == "") {
		alert("確認用のパスワードを入力してください");
		return false;
	} else if (!form.userPassDeleteCheck.value.match(/^([a-zA-Z0-9]{8,})$/)) {
		alert("パスワードは半角英数字で8文字以上に設定してください");
		return false;
	} else if (form.userDeletePass.value == form.userPassDeleteCheck.value !=userPassCheckAnswer){
      alert("パスワードと確認用パスワードが一致しません"); // 一致していなかったら、エラーメッセージを表示する
      return false;
	} else {
		//条件に一致しない場合(入力されている場合)
		return true; //送信ボタン本来の動作を実行します
		
	}
}