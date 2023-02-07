<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<script type="text/javascript">
	let websocket;

	$(document).ready(function() {
		//입장 버튼 클릭했을 때 이벤트 처리
		$('#enterBtn').on('click', function() {

			//웹 소켓 연결
			websocket = new WebSocket("ws://localhost:8090/myapp/chatws.do");

			//웹 소켓 이벤트 처리
			websocket.onopen = onOpen; //소켓 서버에 연결이 됐을 때
			websocket.onmessage = onMessage; //서버에서 클라이언트에 메세지 보냈을 때
			websocket.onclse = onClose;//소켓 서버에 연결이 종료되었을 때
			// --다 소문자
			
		});

		//전송버튼을 눌렀을 때 이벤트 처리
		$('#sendBtn').on('click', function() {
			messageProcess();
		});

		//message 창에서 Enter를 눌렀을 때 메세지를 전송
		//키보드를 누를 때 이벤트 처리
		$('#message').keypress(function(event) {
			if (event.keyCode == 13) {
				messageProcess();
			}
		});
		
		//나가기 버튼을 눌렀을 때
		$('#exitBtn').on('click', function () {
			websocket.close();
		});
	});
	/////////////////////////////////////////////////////////

	function messageProcess() {
		//nickname과 message에 입력된 내용을 서버에 전송
		let nick = $('#nickname').val();
		let msg = $('#message').val();

		//메세지 전송
		websocket.send(nick + ":" + msg);
		//메세지 입력창 초기화
		$('#message').val('');

	}///////////////////////////end messageProcess()/////////

	//WebSocket이 연결 해제된 경우 호출되는 함수
	function onClose(evt) {
        consol.log('웹 소켓에 연결 해제');		
	}
	
	//WebSocket이 연결된 경우 호출되는 횟수
	function onOpen() {
		console.log("웹 소켓에 연결 성공");
	}

	//서버에서 메세지가 왔을 때 호출되는 함수
	function onMessage(evt) {
		console.log('evt:', evt);
		
		//서버가 전송한 메세지 가져오기
		let data = evt.data;
		
		$('#chatMessageArea').append('<p>'+data+'</p>');
	}///////////////////////////end onOpen()//////////////////
	
	
</script>

</head>
<body>
	<span>이름:</span>
	<input type="text" id="nickname" />
	<input type="button" id="enterBtn" value="입장" />
	<input type="button" id="exitBtn" value="나가기" />

	<h1>채팅 영역</h1>
	<div id="charArea">
		<div id="chatMessageArea"></div>
	</div>

	<span>전송할 메시지:</span>
	<input type="text" id="message" />
	<input type="button" id="sendBtn" value="전송" />
</body>
</html>