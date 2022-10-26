 function coladd() {
	//テーブルIDを取得
        var answer_text = document.getElementById("answer_text");
        
        // 行を行末に追加
        var line_row = answer_text.insertRow(-1);
        //td分追加
        var cell1 = line_row.insertCell(-1);
        var cell2 = line_row.insertCell(-1);
        var cell3 = line_row.insertCell(-1);
        // セルの内容入力
        //answer_textの追加の表示
        cell1.innerHTML = '<input type="text" name="answer_text">';
        cell2.innerHTML = '<input type="hidden" name ="answer_id">';
        //行の削除
        //onclick="coldel(this)が削除ボタンが押されたら自分自信を渡す
        cell3.innerHTML = '<input type="button" value=削除" id="coladd" onclick="coldel(this)">';
    }
    function coldel(obj) {
        // 削除ボタンを押下された行を取得
        //parentNode.parentNodeは親の親だからcell3からline_rowの事を表している
        tr = obj.parentNode.parentNode;
        // trのインデックスを取得して行を削除する
        //trの親に、trが所属している行を削除
        //trのsectionRowIndexでどこを消すかを取得している
        tr.parentNode.deleteRow(tr.sectionRowIndex);
    }