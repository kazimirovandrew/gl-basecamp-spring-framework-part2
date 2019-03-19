import basecamp.config.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class GameControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }

    @Test
    public void givenGameURI_whenMockMVC_thenGetStatus() throws Exception {

        mockMvc.perform(get("/game/{num}", 500))
                .andExpect(status().isOk());
    }

    @Test
    public void givenGreetURI_whenMockMVC_thenGetContentType() throws Exception {

        mockMvc.perform(get("/game/{num}", 500))
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void givenGreetURI_whenMockMVC_thenGetJson() throws Exception {

        mockMvc.perform(get("/game/{num}", 500))
                .andExpect(jsonPath("$.result").value("Looser!"));
    }
}
