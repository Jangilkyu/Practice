<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>회원 가입</h3>

<form action="insertMemberOK.jsp" method="post" name="members">
	<table>
		<tr>
			<td><label>아이디 :&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="id" id="id"></td>
			<td><input type="button" value="아이디 중복 검사" id="btnIdCehck"><span id="chckalert"></sapn></td>
		</tr>
		<tr>
			<td><label>비밀번호 : </label><input type="password" name="passwd"></td>
		</tr>
		<tr>
			<td><label>이름 :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="text" name="name"></td>
		</tr>
		<tr>
			<td><label>연락처 :&nbsp;&nbsp;&nbsp;&nbsp;</label><select name="phone1">
															 	<option>선택</option>
															 	<option value="010">010</option>
															 	<option value="011">011</option>
															 	<option value="016">016</option>
															 	<option value="017">017</option>
															 	<option value="019">019</option>
															 </select>-<input type="text" maxlength="4" size="4" name="phone2">-
			<input type="text" maxlength="4" size="4" name="phone3"></td>
		</tr>
		<tr>
			<td><label>성별 :&nbsp;&nbsp; &nbsp; </label><input type="radio" value="남성" name="sex" checked="checked">남성 <input type="radio" value="여성" name="sex">여성</td>
		</tr>
		<tr>
			<td>
				<label>혈액형 : </label>
				<input type="radio" name="bloodType" value="A">A
				<input type="radio" name="bloodType" value="B">B
				<input type="radio" name="bloodType" value="C">C
			</td>
		</tr>
		
		<tr>
			<td>
				<label>취미 : </label>
				<input type="checkbox" name="hobby" value="독서">독서
				<input type="checkbox" name="hobby" value="운동">운동
				<input type="checkbox" name="hobby" value="영화">영화
			</td>
		</tr>
		<tr>
			<td>
				지역 : <select name="city" size="1">
							<option value="서울특별시">서울특별시</option>
							<option value="경기도">경기도</option>
							<option value="인천광역시" selected="selected">인천광역시</option>
							<option value="충청도">충청도</option>
							<option value="전라도">전라도</option>
							<option value="경상북도">경상북도</option>
							<option value="경상남도">경상남도</option>
					 </select>			
			</td>
		</tr>
		
		<tr>
			<td>
				<textarea name="comment" rows="3" cols="30" placeholder="가입인사를 입력해주세요."></textarea>
			</td>
		</tr>
	</table>
	
	<p>
			<input type="submit" value="가입하기">
			<input type="reset" value="다시쓰기">
	</p>
</form>


<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

<script>
$('#btnIdCehck').click(function () {
	
	let data = {
			id : $('#id').val()
	}
	
	$.ajax({
		url :'idCheck.jsp',
		data : data
	}).done(function (data) {
			//alert(data.msg);

			let chksucc = $('#id').val()+"는 사용할 수 있습니다.";
			let chkfail = $('#id').val()+"는 이미 사용되는 아이디입니다.	";
			if(data.msg){
			$('#chckalert').html(chkfail).css('color','red');
			}else{
				$('#chckalert').html(chksucc).css('color','blue');
			}
	});
	
});
</script>


</body>
</html>