package nl.fontys.s3.chatservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import nl.fontys.s3.chatservice.controller.MessageController;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.fontys.s3.chatservice.VO.MessageVO;
import nl.fontys.s3.chatservice.controller.MessageController;
import nl.fontys.s3.chatservice.entity.Message;
import org.junit.jupiter.api.Test;

//import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.extension.ExtendWith;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.security.Principal;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ChatServiceApplicationTests {

	@Autowired
	private MessageController messageController;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private MockMvc mvc;

	@Test
	@WithMockUser()
	public void contextLoads() throws Exception {
		assertThat(messageController).isNotNull();
	}

	/*@Test
	public void shouldCreateMessage() throws Exception {
		KeycloakPrincipal mockPrincipal = Mockito.mock(KeycloakPrincipal.class);
		Mockito.when(mockPrincipal.getKeycloakSecurityContext().getToken().getSubject()).thenReturn("5");

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/message/create")
				.principal(mockPrincipal)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		//Assert.assertEquals("response status is wrong", 200, status);
		//MockHttpServletRequestBuilder
		//mockHttpServletRequest.setUserPrincipal(Principal);
		MessageVO messageToPost = new MessageVO();
		messageToPost.setDescription("Test description");

		String messageAsString = mapper.writeValueAsString(messageToPost);

		mvc.perform(post("/message/create")
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization","Bearer ")
				.content(messageAsString)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.messageId").value(1L))
				.andExpect(jsonPath("$.name").value("Test description"))
				.andExpect(jsonPath("$.userId").value("5"));
	}*/

}
