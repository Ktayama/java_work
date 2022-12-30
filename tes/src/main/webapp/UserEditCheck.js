function EditCheck() {
	
	var userPass = document.form.userPass.value;
	var userPassCheck = document.form.userPassCheck.value;
	
	if (form.userPass.value == "") {
		alert("パスワードを入力してください");//エラーメッセージを出力
		return false; //送信ボタン本来の動作をキャンセルします
	} else if (!form.userPass.value.match(/^([a-zA-Z0-9]{8,})$/)) {
		alert("パスワードは半角英数字で8文字以上に設定してください"); //エラーメッセージを出力
		return false;//送信ボタン本来の動作をキャンセルします
	} else if (form.userPassCheck.value == "") {
		alert("確認用のパスワードを入力してください");
		return false;
	} else if (!form.userPassCheck.value.match(/^([a-zA-Z0-9]{8,})$/)) {
		alert("パスワードは半角英数字で8文字以上に設定してください");
		return false;
	} else if (form.userPass.value != form.userPassCheck.value){
      alert("パスワードと確認用パスワードが一致しません"); // 一致していなかったら、エラーメッセージを表示する
      return false;
	} else {
		//条件に一致しない場合(入力されている場合)
		return true; //送信ボタン本来の動作を実行します
		
	}
}