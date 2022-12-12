package com.billpay;

import com.billpay.service.DataInjectorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BillpayApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(BillpayApplication.class, args);
		DataInjectorService dataInjectorService = configurableApplicationContext.getBean(DataInjectorService.class);
		dataInjectorService.injectStaticData();
	}

}
