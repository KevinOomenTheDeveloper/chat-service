package nl.fontys.s3.chatservice;

import static org.assertj.core.api.Assertions.assertThat;

import nl.fontys.s3.chatservice.entity.Message;
import nl.fontys.s3.chatservice.service.MessageService;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class ChatServiceApplicationTests {

	@Autowired
	private MessageService messageService;

	@Test
	public void contextLoads() throws Exception {
		assertThat(messageService).isNotNull();
	}

	@Test
	public void shouldSaveMessage(){
		Message message = new Message("Test description.", "1");
		assertThat(messageService.saveMessage(message)).isEqualTo(new Message(1L, "Test description.", "1"));
	}

	@Test
	public void shouldGetMessage(){
		assertThat(messageService.getMessage(1L)).isEqualTo(new Message(1L, "test1", "1"));
	}

	@Test
	public void shouldGetLogs(){
		List<Message > expectedMessages = new ArrayList<Message>();
		expectedMessages.add(new Message(1L, "test1", "1"));
		expectedMessages.add(new Message(3L, "test3", "1"));
		assertThat(messageService.getLogs("1")).isEqualTo(expectedMessages);
	}
}
