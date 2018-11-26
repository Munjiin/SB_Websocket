package org.gorany;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

	@MessageMapping("/hello") //hello api로 메세지를 보내면 메소드가 호출
	@SendTo("/topic/greetings") //리턴 값은 브로드캐스팅
	public Greeting greeting(HelloMessage message) throws Exception{
		Thread.sleep(1000);
		return new Greeting(HtmlUtils.htmlEscape(message.getName()));
	}

   

}