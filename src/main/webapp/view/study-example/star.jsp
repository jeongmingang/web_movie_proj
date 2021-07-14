<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/movie/star/fontawesome-stars.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <script>
    	window.jQuery || document.write('<script src="${contextPath}/resources/js/star/vendor/jquery-1.11.2.min.js"><\/script>')
    </script>	
    <script src="${contextPath}/resources/js/star/jquery.barrating.min.js"></script>
    <script type="text/javascript"> 
    	$(function() { 
    		$('#example-fontawesome').barrating({ 
    			theme: 'fontawesome-stars' 
   			}); 
   		}); 
    	
		$().ready(function () {
            $("#alertStart").click(function () {
                Swal.fire({
                    icon: 'success',
                    title: 'Alert가 실행되었습니다.',
                    text: '이곳은 내용이 나타나는 곳입니다.',
                });
            });
        });

	$().ready(function () { 
		$("#confirmStart").click(function () { 
			Swal.fire({ 
				title: '등록하시겠습니까?', 
				icon: 'warning', 
				showCancelButton: true, 
				confirmButtonColor: '#3085d6', 
				cancelButtonColor: '#d33', 
				confirmButtonText: '등록', 
				cancelButtonText: '취소' 
				}).then((result) => { 
					if (result.isConfirmed) { 
						Swal.fire('등록되었습니다.', '소중한 한줄평 감사합니다.', 'success' ).then(function(){
							alert("확인버튼 누름");
						});
					} else{    
						alert("취소버튼 누름");
				 	}
				});
			}); 
		});
    </script>
</head>
<body>
	<select id="example-fontawesome" name="rating" autocomplete="off">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
	</select>
	
	<button id="alertStart">Alert 실행</button>
	<button id="confirmStart">Confirm 실행</button>
</body>
</html>