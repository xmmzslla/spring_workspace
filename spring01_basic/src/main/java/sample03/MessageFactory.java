package sample03;

public class MessageFactory {
	
	public MessageFactory() {
		
	}//m
	
	public static MessageBean getInstance(String type) {
		if(type.equals("ko")) {
			return new MessageBeanKorea();
		}else if(type.equals("en")) {
			return new MessageBeanEnglish();
		}else {
			return null;
		}
		
	}//getInstance()

}//c
