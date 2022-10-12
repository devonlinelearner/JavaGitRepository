package com.bookingdemo;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
@CrossOrigin
public class CreateHtmlFromInputStringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateHtmlFromInputStringApplication.class, args);
	}

	 // Post /saveInputAsHTMLFile
		@PostMapping("/saveInputStringAsHTMLFile")
		String saveEmployee(@RequestBody String message) {
			System.out.println("Input from UI is : "+message);
			
			//Creating an instance of file
			Path path
			    = Paths.get("D:\\ElasticSearchWorkspace\\CreateHTMLFromInputString\\CreateHTMLFromInputString\\src\\main\\resources\\index_v1.html");
			// D:\\ElasticSearchWorkspace\\CreateHTMLFromInputString\\CreateHTMLFromInputString\\src\\main\\resources

			// Custom string as an input
			String str
			    = message;

			Document html = Jsoup.parse(message);
	 
	        System.out.println("Input HTML String to JSoup :" + message);
	        //System.out.println("After parsing, Title : " + title);
	        //System.out.println("Afte parsing, Heading : " + h1);
	        String body = html.body().getElementsByTag("p").text();
	        System.out.println("Contents from the body tag of parsed html"+body);
			// Try block to check for exceptions
			try {
			    // Now calling Files.writeString() method
			    // with path , content & standard charsets
			   // Files.write(path, str,StandardCharsets.UTF_8);
			    //Files.write(path, str.getBytes(), StandardCharsets.UTF_8);
			    Files.write(path, str.getBytes(StandardCharsets.UTF_8));
			}

			// Catch block to handle the exception
			catch (IOException ex) {
			    // Print messqage exception occurred as
			    // invalid. directory local path is passed
			    System.out.print("Invalid Path");
			}
			
			
			return message;
		}
}


