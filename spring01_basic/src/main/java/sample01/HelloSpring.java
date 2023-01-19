package sample01;

/*
 * 결합도
 * 1. 클래스 간의 상호 연결성 측정을 의미한다.
 * 2. 낮은 결합도를 가지려면 하나의 객체 변경이 다른 객체에 영향을 미쳐서는 안된다.
*/
public class HelloSpring {

	public static void main(String[] args) {
//		MessageBeanKorea been = new MessageBeanKorea();
//		display(been, "스프링");
		
		MessageBeanEnglish bean = new MessageBeanEnglish();
		display(bean, "Spring");
	}//m
	
	public static void display(MessageBeanEnglish bean, String name) {
		bean.sayHello(name);
	}//display

}//c
