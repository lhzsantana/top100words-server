package com.words.server;
import java.util.List;

import org.apache.catalina.Server;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.words.server.services.WordsService;

@SpringBootApplication
@RestController("/example")
@EnableAutoConfiguration
@ComponentScan
public class Application {

	final static Logger logger = Logger.getLogger(Server.class);

    @Autowired
	private WordsService services;
    
    @RequestMapping(value = "/allWords", method=RequestMethod.POST)
    public @ResponseBody List<String> getAllWords(@RequestBody AllWordsRequest request) {
    	
    	logger.info("A new request for all words");
    	
    	return services.getAllWords();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class);
    }
}