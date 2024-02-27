package in.optit.optitlabservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String getGreeting() {
		return "Welcome to the Opt IT Lab Sample Application!";
	}

	@GetMapping("/_status/healthz")
	public String getHealth() {
		return "OK";
	}

}
