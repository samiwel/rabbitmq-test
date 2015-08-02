package listeners;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener implements MessageListener {

	@Override
	public void onMessage(Message arg0) {
		
		System.out.println("onMessage() is being invoked");
		
		try {
			String content = new String(arg0.getBody(), "UTF-8");
			System.out.println(content);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

}
