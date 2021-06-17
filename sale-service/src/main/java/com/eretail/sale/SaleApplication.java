package com.eretail.sale;

import com.eretail.sale.entites.Sale;
import com.eretail.sale.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class SaleApplication implements CommandLineRunner {

	@Autowired
	private SaleRepository saleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SaleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Date date = new Date();

		Sale s1 = new Sale("Carlos", "Luiz", date, new BigDecimal(100.50));
		Sale s2 = new Sale("Maria", "Luiz", date, new BigDecimal(65.05));
		Sale s3 = new Sale("Felipe", "Tais", date, new BigDecimal(50));

		saleRepository.saveAll(Arrays.asList(s1, s2, s3));

	}
}
