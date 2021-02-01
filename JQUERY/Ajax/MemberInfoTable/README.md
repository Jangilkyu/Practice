# 회원 리스트
현재 HTML 화면에는 많은 컨텐츠가 있다고 가정합니다. `등록 버튼`을 클릭하면 화면 전체를 전환하지 않고 DB서버에 추가를 하고 다시 오게 끔  Ajax통신을 해보고자 합니다. 
<hr>

## 제작기간
2021년 1월 29일(금) ~ 2021년 1월 31(일)
<hr>

**member테이블**은 아래와 같이 정의 되어 있습니다.
<img src ="https://user-images.githubusercontent.com/69107255/106282533-10ae5e00-6284-11eb-9389-49e9d557610d.png">


# 회원 등록

**추가 버튼**에 이벤트를 걸어서 사용자가 입력한 값을 `let data = $("#input").serializeArray();`를 통해서 가져왔습니다.

**.serializeArray()** 는 *<form*>태그 내부의 값을 `JSON형태로 문자열을 배열`로 리턴합니다. 

`let data = $("#input").serializeArray();`에 data에 담긴 값을 console.log를 통해서 값을 출력했을 때 객체 문자열 형태로 저장되어 있는 것을 확인 할 수 있습니다.    

<img src = "https://user-images.githubusercontent.com/69107255/106280720-9bda2480-6281-11eb-894e-ac14dec1671f.png">

**index.html**
```javascript
	$('#btnInsert').click(function () {
	   		
		let data = $("#input").serializeArray();
			
		console.log(data);

		$.ajax({
			url : 'insertMember.jsp', //추가를 할 프로그램명
			data : data /*data속성 : data-> 서버로 보낼 데이터*/
                    
	   	}).done(function (data/*서버가 나에게 응답해준 데이터*/) {
			viewMemberList();
		});   		
	});
```

# 회원 읽기

추가된 회원들의 회원리스트를 읽어오고자 합니다.
버튼이 클릭되면 `readMember.jsp`로 이동하여 DB에 있는 회원 정보들을 읽어와서 viewMemberList함수에 정보들을 인자값으로 전달합니다.
```javascript
	$('#btnRead').click(function () {
	   	$.ajax({
	   		url:'readMember.jsp',
	   	}).done(function (data) {
	   		viewMemberList(data);
	   	});
	});
```

viewMemberList 함수에서는 파라미터로 받은 회원 정보들을 *<tbody*>에 아이디인 `#memberList`에 붙여 줍니다. `회원리스트 가져오기` 버튼을 계속 클릭 시 테이블을 계속 만들기 때문에 each-loop를 돌기 전에 `.empty()` 함수를 사용해 테이블을 비워줍니다.  ecah문 에서는 바깥 each 문에서는 **item(행의 수)** 만큼 ``을 노드를 동적으로 만들어 줍니다. 안쪽 each 문에서는 item(행)에 들어 있는 `id`,`name`,`email`의 개수 만큼 `<td>td>`를 만들어 td안에 들어가는 값을 `.html()` 안에 넣어 `appendTo()`를 통해서 tr에 추가한다.
*<tbody*>에 tr을 추가해준다.
```javascript
	let viewMemberList = function(arr){
		$("#memberList").empty();
			
		$.each(arr, function(i,item){
			let tr = $("<tr></tr>");
			console.log(item)
			$.each(item, function(key,value){
				$("<td></td>").html(value).appendTo(tr);
			});
			$("#memberList").append(tr);
		});
	}
```

`회원리스트 가져오기`버튼을 클릭 시 위에 추가한 회원에 리스트가 잘 나오는 것을 확인할 수 있습니다.

<img src ="https://user-images.githubusercontent.com/69107255/106347470-21051e00-6302-11eb-8dc9-c45f2a2ed499.png">

# 회원 수정

수정하기 전에 `회원리스트 가져오기` 버튼을 통해 불러온 리스트 정보들의 행을 클릭 시 `<input>`text 입력 칸에 행에 값들을 불러 오고자 합니다.
최상단 요소(document)에서 `tr`을 클릭 시 이벤트를 발생하도록 하였습니다.

`td_arr` 변수에는 `this`즉 클릭한 tr의 요소에 정보가 있습니다. `.find('td')`를 통해서 tr태그의 후손인 `td`태그들의 값을 `td_arr` 변수인 배열에 담았다.

클릭 된 행을 구분하기 위해서 `active`라는 CSS 요소 클래스를 만들었고 background를 pink로 설정하였습니다. `$(this).addClass('active');` 클릭 된 행에 active 클래스를 통해서 css가 반영되도록 하였다. 하지만 문제점이 클릭할 때마다 모든 행이 반영된다. 따라서 `$('tr').removeClass('active');`을 통해서 색을 칠하기 전에 반영되었던 `tr태그`들의 모든 색을 비워주고 칠하도록 설정하였습니다.

```javascript
	   $(document).on('click','tr',function(){
		   let td_arr = $(this).find('td');
		   
		   $('tr').removeClass('active');
		   $(this).addClass('active');
		   
		   $('#id').val($(td_arr[0]).text());
		   $('#name').val($(td_arr[1]).text());
		   $('#email').val($(td_arr[2]).text());
	   });
```
실험을 위해서 임의에 회원들을 추가 하였습니다.

행을 클릭시 background가 변경이 되는 것 을 확인 할 수 있습니다.
<img src ="https://user-images.githubusercontent.com/69107255/106349976-be1d8200-6315-11eb-870b-fa09dcf56c2f.png">

또한, **장일규회원**에서 **류수정회원**을 클릭 시 input태그 안에 text들 또한 클릭 된 행에 정보로 변경이 됩니다.
<img src ="https://user-images.githubusercontent.com/69107255/106350075-7d723880-6316-11eb-9ad1-b50ce093b21e.png">

따라서, 회원정보 버튼 클릭 시 `회원 등록`때와 마찬가지로 `	   	let data = $('#input').serializeArray();`을 통해서 사용자가 입력한 input값들을 form태그 아이디를 통해서 가져와서 변수에 담았고, **updateMember.jsp**로 data와 함께 Ajax통신을 하기위해 서버로 보냈습니다.

```javascript
	$('#btnUpdate').click(function () {
	   	let data = $('#input').serializeArray();
	   	console.log(data);
		$.ajax({
			url : 'updateMember.jsp',
			data:data
		}).done(function (data) {
			$.ajax({
		   		url:'readMember.jsp',
		   	}).done(function (data) {
		   		viewMemberList(data);
		   	});
		});
	});
```

`장일규회원`에 이름을 `어드민`으로 바꿔보았습니다.

<img src ="https://user-images.githubusercontent.com/69107255/106350197-4e0ffb80-6317-11eb-91e7-06b0c5bb23d2.png">

# 회원 삭제

삭제는 `PRIMARY KEY`인 아이디를 통해서 삭제가 된다. DB서버로 보낼때 값이 많지 않기 때문에 `id`값만 제이쿼리를 통해서 가져와서 data를 보내주었습니다.

```javascript
	$('#btnDelete').click(function () {
	   	let id = $('#id').val();
	   	let data = {
	   			id:id
	   	}
	   	$.ajax({
	   		url : 'deleteMember.jsp',
	   		data : data
	   	}).done(function (data) {
		$.ajax({
		   		url:'readMember.jsp',
		   	}).done(function (data) {
		   		viewMemberList(data);
		   	});
		})
	});
```

아이디가 `Jang`인 회원을 클릭하고 삭제가 이루어진 것을 확인 할 수 있습니다.

<img src = "https://user-images.githubusercontent.com/69107255/106386399-248ac900-6418-11eb-89e5-151ddd413eb0.png">


최종적으로 member테이블에 저장	되어있는 것을 확인할 수 있습니다.
<img src = "https://user-images.githubusercontent.com/69107255/106386814-2190d800-641a-11eb-9008-2c27ebe7f68a.png">