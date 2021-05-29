package nl.fontys.s3.chatservice;

import static org.assertj.core.api.Assertions.assertThat;

import nl.fontys.s3.chatservice.controller.MessageController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatServiceApplicationTests {

	@Autowired
	private MessageController messageController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(messageController).isNotNull();
	}

}
