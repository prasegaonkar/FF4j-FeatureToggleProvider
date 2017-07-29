package edu.mywork;

import static javax.measure.unit.SI.KILOGRAM;

import java.util.Map;

import javax.measure.quantity.Mass;

import org.jscience.physics.amount.Amount;
import org.jscience.physics.model.RelativisticModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class App extends SpringBootServletInitializer {
	@RequestMapping("/hello")
	String hello(Map<String, Object> model) {
		RelativisticModel.select();
		Amount<Mass> m = Amount.valueOf("12 GeV").to(KILOGRAM);
		model.put("science", "E=mc^2: 12 GeV = " + m.toString());
		return "hello";
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

}