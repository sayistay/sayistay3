package tr.gov.sayistay;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tr.gov.sayistay.beans.Araba;
import tr.gov.sayistay.beans.Personel;

@SpringBootApplication
public class SpringOrnekleriApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SpringOrnekleriApplication.class, args);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");
		System.out.println("Context alindi");
		Araba araba = (Araba) context.getBean("araba");
		System.out.println(araba);
		Araba araba2 = (Araba) context.getBean("araba");
		System.out.println(araba2);
		if (araba == araba2) {
			System.out.println("Eşit");
		}
		Personel personel = (Personel) context.getBean("personel");
		System.out.println(personel);

		Personel personel2 = (Personel) context.getBean("personel2");
		System.out.println(personel2);
		context.close();
	}

}
