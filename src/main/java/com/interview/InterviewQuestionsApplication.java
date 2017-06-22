package com.interview;




import com.interview.deadlock.DeadLockDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class InterviewQuestionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewQuestionsApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(InterviewQuestionsApplication.class);


	@PostConstruct
	public void test(){

		int nu =5656;

		log.info(Integer.toBinaryString(nu));

		nu=nu>>>3;

		log.info(Integer.toBinaryString(nu));

		log.info(String.format("%d", nu));

	}


}
