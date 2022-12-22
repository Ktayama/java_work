

function check() {
	var userName = document.getElementById("name").value; //メールフォームの値を取得
    var usersPass = document.getElementById("usersPass").value; //メール確認用フォームの値を取得
    var userPassCheck = document.getElementById("userPassCheck").value; //メール確認用フォームの値を取得
    
	if (form.userName.value == "") {
		//条件に一致する場合
		alert("名前を入力してください"); //エラーメッセージを出力
		return false; //送信ボタン本来の動作をキャンセルします
	} else if (!form.userName.value.match(/^[A-Za-z0-9]*$/)) {
		alert("名前は半角英数字のみです"); //エラーメッセージを出力
		return false; //送信ボタン本来の動作をキャンセルします
	} else if (form.usersPass.value == "") {
		alert("パスワードを入力してください");
		return false;
	} else if (!form.usersPass.value.match(/^([a-zA-Z0-9]{8,})$/)) {
		alert("パスワードは半角英数字で8文字以上に設定してください");
		return false;
	} else if (form.userPassCheck.value == "") {
		alert("確認用のパスワードを入力してください");
		return false;
	} else if (!form.userPassCheck.value.match(/^([a-zA-Z0-9]{8,})$/)) {
		alert("パスワードは半角英数字で8文字以上に設定してください");
		return false;
	} else if (form.usersPass.value != form.userPassCheck.value){
      alert("パスワードと確認用パスワードが一致しません"); // 一致していなかったら、エラーメッセージを表示する
      return false;
	} else {
		//条件に一致しない場合(入力されている場合)
		return true; //送信ボタン本来の動作を実行します
	}
}