
document.addEventListener('DOMContentLoaded', function() {

var user_neam = document.getElementById("alpha");




  // ----------------------------------------------
  // 数字とハイフン記号の入力チェック用スクリプト
  // ----------------------------------------------
  var targets = document.getElementsByClassName('alpha');
  for (var i=0 ; i<targets.length ; i++) {
    // 文字が入力されたタイミングでチェックする：
    targets[i].oninput = function () {
      var alertelement = this.parentNode.getElementsByClassName('alertarea');
      if( ( this.value != '') && ( this.value.match(  /[^0-9a-zA-Z+$]/  )) ) {
        // 何か入力があって、指定以外の文字があれば
        if( alertelement[0] ) { alertelement[0].innerHTML = '入力には、半角英数字だけが使えます。'; }
        this.style.border = "2px solid red";
      }else 
      {
        // 何も入力がないか、または指定文字しかないなら
        if( alertelement[0] ) 
        { 
			alertelement[0].innerHTML = "";
		}
		this.style.border = "1px solid black";
	   }if(alertelement[0]){
			
	   }
    }
  }




  // -------------------------------
  // [user_pass]8文字以上の英数字の入力チェック
  // -------------------------------
  //HTMLソース内でclass名に「chars8」が指定させれた要素をuser_passに格納
  var user_pass = document.getElementsByClassName('chars8');
  var user_pass_confirm = document.getElementById('userPassCheck');
  
  for (var i=0 ; i<user_pass.length ; i++) {
    // 文字が入力されたタイミングでチェックする：
    //HTMLで文字が入力されたり、マウスなどで文字が貼り付けられた場合に処理が実行される
    user_pass[i].oninput = function () 
     {
	//対象の要悪と同じ親要素に含まれる、class名が「」
	 var alertelement = this.parentNode.getElementsByClassName('alertarea');

		//条件1：英数字以外の文字があるかどうかを判断（1文字以上入力されている場合）
		//「this.value != '」は何も入力されていなければチェックしない
		if( ( this.value != '') && ( this.value.match( /[^0-9a-zA-Z+$]/  )) ) {
			// 英数字以外の文字があれば
			if( alertelement[0] ) 
			{	
				alertelement[0].innerHTML = "入力には、半角英数字だけが使えます。"; 	
			}
			this.style.border = "2px solid red";
		}
		// 条件2：空白を除いた入力文字数が6文字よりも少ないかどうかを判断
		else if( this.value.length < 8 ) 
		{
			// 入力文字数が8文字よりも少なければ
			if( alertelement[0] )
			{
				alertelement[0].innerHTML = "入力文字数が少なすぎます。半角英数字で8文字以上を入力して下さい。"; 
			}
			this.style.border = "2px solid orange";
			
		}else 
		{
			// 英数字が8文字以上あれば
			if( alertelement[0] ) 
			{
				 alertelement[0].innerHTML = ""; 
			}
			this.style.border = "1px solid black";
		}
	}
	}




//HTMLでform要素を対象に入力チェックを実行する
//form要素の全てをtargetsに格納

 var targets = document.getElementsByClassName('checkform');
 	for (var i=0 ; i<targets.length ; i++) {
	
	// 送信直前で全項目を再度チェックしてエラーを数える：
	targets[i].onsubmit = function () {
		var inputelements = this.querySelectorAll('input,textarea');  // フォームの中にあるinput要素とtextarea要素をすべて得る
		var alerts = this.getElementsByClassName('alertarea');
		var ret = 0;
		
	// ――――――――――――――――――
	// 全項目のoninputイベントを一括実行
	// ―――――――――――――――――
	for (var j=0 ; j<alerts.length ; j++) {
		if( inputelements[j].oninput ) {
			 // oninputイベントが定義されている場合にだけ実行する
			 inputelements[j].oninput();
		}
	}
	// アラートの表示数をカウントする
	for (var j=0 ; j<alerts.length ; j++) {
		if( alerts[j].innerHTML.length > 0 ) {
			// アラートが表示されていればカウント
			ret++;
		}
	}
	if( ret == 0 ) {
		// エラーメッセージが1つもなければ送信を許可
		return true;
		}
      else {
        // エラーメッセージが1つ以上あれば、アラートを表示して送信をブロック。
        alert( ret + "個のエラーがあります。");// ※警告用のダイアログボックスを表示したくないなら、この行は削除。
        return false;
      }

    }
  }

});


