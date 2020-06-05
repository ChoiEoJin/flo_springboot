package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class DemoApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	
   @Test
    public void searchTest() throws Exception {
        mockMvc.perform(get("/search?locale=ko&title=Please"))
        		.andExpect(status().isOk());
    }
   
   
   @Test
   public void albumsTest() throws Exception {
       mockMvc.perform(get("/albums?locale=en&page=2"))
       			.andExpect(status().isOk());
   }
   
   @Test
   public void getPlaylistTest() throws Exception {
	   mockMvc.perform(get("/playlist/1")
			   .header("Authorization", "LOGGED_IN"))
	   			.andExpect(status().isOk());
   }
   
   @Test
   public void createPlaylist() throws Exception {
	   
	  String requestBody = "{\"playlistName\" : \"test_playlist\", \"userId\": \"1\"}" ;
	  mockMvc.perform(post("/playlist/create")
			  		.header("Authorization", "LOGGED_IN")
			  		.contentType(MediaType.APPLICATION_JSON)
			  		.content(requestBody))
	  				.andExpect(status().isOk());
   }
   
   @Test
   public void addSongInPlaylistTest() throws Exception {
	   
	  String requestBody = "{\"playlistId\" : \"1\", \"songs\": [1, 2, 3], \"albums\": {\"id\": \"2\"}}" ;
	  mockMvc.perform(post("/playlist/addsong")
			  		.header("Authorization", "LOGGED_IN")
			  		.contentType(MediaType.APPLICATION_JSON)
			  		.content(requestBody))
	  				.andExpect(status().isOk());
   }
   
   @Test
   public void removePlaylistTest() throws Exception {
	   
	  String requestBody = "{\"playlistId\" : \"1\", \"userId\": \"1\"}" ;
	  mockMvc.perform(post("/playlist/remove")
			  		.header("Authorization", "LOGGED_IN")
			  		.contentType(MediaType.APPLICATION_JSON)
			  		.content(requestBody))
	  				.andExpect(status()
	  				.isOk());
   }
   
   @Test
   public void searchBadRequestTest() throws Exception {
	   mockMvc.perform(get("/search?locale=ko&title="))
	   			.andExpect(status().isBadRequest());
   }

   @Test
   public void albumBadRequestTest() throws Exception {
	   mockMvc.perform(get("/albums?locale="))
	   			.andExpect(status().isBadRequest());
   }

   @Test
   public void playlistBadRequestTest() throws Exception {
	   mockMvc.perform(get("/playlist/dd")
			   .header("Authorization", "LOGGED_IN"))
	   			.andExpect(status().isBadRequest());
	   			
   }

   @Test
   public void playlistUnAuthorizeTest() throws Exception {
	   
	   mockMvc.perform(get("/playlist/1"))
	   			.andExpect(status().is3xxRedirection());
	   
	   mockMvc.perform(get("/login/invalid"))
			.andExpect(status().isUnauthorized()); 
   }
   
   @Test
   public void notFoundTest() throws Exception {
	   mockMvc.perform(get("/nofound"))
	   			.andExpect(status().isNotFound());
   }
   
   @Test
   public void internalServerErrorTest() throws Exception {
	  
	  String requestBody = "{\"playlistName\" : \"test_playlist\", \"userId\": \"USER\"}" ;
	  
	  
	  mockMvc.perform(post("/playlist/create")
			  		.header("Authorization", "LOGGED_IN")
			  		.contentType(MediaType.APPLICATION_JSON)
			  		.content(requestBody))
	  				.andExpect(status().is5xxServerError());
   }

	
}
