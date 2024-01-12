package com.springdemo.bootboard;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class MySpringBoardApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MySpringBoardApplication.class);
	}

	 public static void main(String[] args) {

		SpringApplication.run(MySpringBoardApplication.class, args);
	}
}

	@RestController
	class SessionController{

		@Value("${spring.redis.host}")
	    private String ip = null;

//		private static String ip;

		public SessionController(@Value("${CF_INSTANCE_IP:127.0.0.1}") String ip){
			this.ip = ip;
		}

		@GetMapping("/session")
		Map<String, String> uid(HttpSession session){
			System.out.println("여기여기"+session);
			UUID uid = Optional.ofNullable(UUID.class.cast(session.getAttribute("uid")))
					.orElse(UUID.randomUUID());
			session.setAttribute("uid", uid);
			System.out.println("여기여기"+this.ip);
			System.out.println("여기여기"+uid.toString());
			Map<String, String> m = new HashMap<>();
			m.put("instance_ip", this.ip);
			m.put("sessionId", uid.toString());
			return m;
		}
//		@PostMapping("/session")
//		public String sessionTest(HttpSession httpSession) {
//			String id = "test321";
//			httpSession.setAttribute("sessionID", id);
//			return "session TEST";
//		}
	}