package part01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * IoC(Inversion of Control 제어의 역전)
 *    객체생성이나 매소드 호출을 개발자가 직접하는 것이 아니라, 
 *    스프링 프레임워크에게 제어권을 넘기는 기능이다.
 * 
 *    대부분의 프레임워크에서 IoC를 적용하고 있다.
 * 
 * DI(Dependency Injection 의존성 주입)
 * 1. 객체를 직접 생성하지 않고 외부에서 생성된 객체를 주입받아 이용하는 기능이다.
 * 2. DI는 컨테이너를 통해 서로 결합되어있는 두 클래스를 분리하고 
 *    두 객체의 관계를 결정해 줌으로써 
 *    결합도를 낮추고 유욘성 확보를 하기 위해서 사용된다.
*/
public class SpringTest {

	public static void main(String[] args) {
		
		//ApplicationContext : Bean의 라이프 사이클을 관리해주는 컨테이너이다.
		String path = "part01/di.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);

		MessageBean bean = (MessageBean)context.getBean("mb");
//		display(bean, "스프링");
		display(bean, "Spring");
	}//m
	
	public static void display(MessageBean bean, String name) {
		
		bean.sayHello(name);
	}

}//c
