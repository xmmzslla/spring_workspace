package sample02;

public class HelloSpring {

	public static void main(String[] args) {
		MessageBean bean = null;
//		bean = new MessageBeanKorea();
//		display(bean, "스프링");
		
		bean = new MessageBeanEnglish();
		display(bean, "Spring");
		
	}//m
	
	public static void display(MessageBean bean, String name) {
		bean.sayHello(name);
	}//display

}//c
