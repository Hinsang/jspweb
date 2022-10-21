package controller.board;

import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Hashtable;

import javax.websocket.*;

@ServerEndpoint("/chatting/{mid}")
public class chatting{
	// 0. 접속명단 [ 세션=클라이언소켓 , 아이디 ] = map 
	public static Hashtable< Session , String > clients = new Hashtable<>();
	
	public void sendAlarm( String content ) throws IOException {
		////////////////////// 접속 알림 메시지 ////////////////////
		// 전송 메시지 구성
		JSONObject object = new JSONObject();
		object.put("type", "alarm");
		object.put("content", content);
		
		// 현재 접속한 모든 세션에게 메시지 전송
		for( Session s : clients.keySet() ) {
			s.getBasicRemote().sendText(object.toString());
		}
		/////////////////////////////////////////////////
	}
	
	// 1. 접속
	@OnOpen	// 웹소켓이 들어왔을때 
	public void OnOpen( Session session , @PathParam("mid") String mid  ) throws IOException {
		clients.put(session, mid); // 서버소켓에서 해당 세션 지우기
		sendAlarm(mid+"님이 들어왔습니다.");

	}
	// 2. 나가기 
	@OnClose // 웹소켓을 나갔을때 
	public void onClose( Session session ) throws IOException {
		///////////////// 나갔을때 알람 메시지 //////////////////
		// 전송 메시지 구성
		JSONObject object = new JSONObject();
		object.put("type", "alarm");
		object.put("content", clients.get(session)+" 님이 퇴장했습니다. ");
		clients.remove(session);
		// 현재 접속한 모든 세션에게 메시지 전송
		for( Session s : clients.keySet() ) {
			s.getBasicRemote().sendText(object.toString());
		}
	}
	// 3. 메시지 받기
	@OnMessage // 웹소켓에 메시지 왔을때 
	public void onMessage( Session session , String msg ) throws IOException {
		for( Session s : clients.keySet() ) {
			s.getBasicRemote().sendText(msg);
		}
	}
}









