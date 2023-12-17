package org.softuni.repairShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RepairShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepairShopApplication.class, args);
	}

}
