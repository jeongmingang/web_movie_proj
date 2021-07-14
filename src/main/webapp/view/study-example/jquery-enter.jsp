<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Jquery 엔터키 이벤트</title>
	<style type="text/css">
		.box {
    border-style: solid;
    border-width: 1px;
    display: block;
    width: 100px;
    height: 100px;
    background-color: #0000FF;
    -webkit-transition:width 2s, height 2s, background-color 2s, -webkit-transform 2s;
    transition:width 2s, height 2s, background-color 2s, transform 2s;
}
.box:hover {
    background-color: #FFCCCC;
    width:200px;
    height:200px;
    -webkit-transform:rotate(180deg);
    transform:rotate(180deg);
}
	</style>
</head>
<body>

   <input type="text" id="alpreah_input">
 
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
    <script>
	    $("#alpreah_input").on("keyup", function(key) {
	        if (key.keyCode == 13) {
	            alert("엔터키를 눌렀습니다.");
	        }
	    });
    </script>
    
    <p>아래 박스는 width, height, background-color, transform을 위한 트랜지션을 결합합니다. 박스 위에 마우스를 올려 속성들의 애니메이션을 보세요.</p>
    <div class="box"></div>
    
</body>
</html>