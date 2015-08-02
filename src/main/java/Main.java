import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		ApplicationContext context = new GenericXmlApplicationContext("classpath:/applicationContext.xml");
		
		AmqpTemplate template = context.getBean(AmqpTemplate.class);
		
		MessageProperties messageProperties = MessagePropertiesBuilder.newInstance()
				.setContentType("text/plain").build();
		
		Message message = new Message("Hello World".getBytes(), messageProperties);
		

		template.send("myExchange", "mykey", message);
	}

}
