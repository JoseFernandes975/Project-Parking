package com.sergim.zuup.config;

import java.util.*;

import com.sergim.zuup.entities.Vacancy;
import com.sergim.zuup.repositories.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

import com.sergim.zuup.entities.Car;
import com.sergim.zuup.entities.Driver;
import com.sergim.zuup.repositories.CarRepository;
import com.sergim.zuup.repositories.ClientRepository;



@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private CarRepository carRepo;

	@Autowired
	private VacancyRepository vacaRepo;
	
	@Override
	@GetMapping
	public void run(String... args) throws Exception {
	Driver c1 = new Driver(null, "Sergim", 30, "true");
	Driver c2 = new Driver(null, "Jose", 18, "true");
	Driver c3 = new Driver(null, "Alisson", 20, "true");
	Driver c4 = new Driver(null, "Maria", 19, "true");
	Driver c5 = new Driver(null, "Fernando", 23, "true");
	Driver c6 = new Driver(null, "Felipe", 27, "true");
	Driver c7 = new Driver(null, "Wesley", 25, "true");
	Driver c8 = new Driver(null, "Paulo", 31, "true");
	Driver c9 = new Driver(null, "Pedro", 27, "true");

	Car car1 = new Car(null, "Hb20s", c1, "HJSCAP2", "Branco");
	Car car2 = new Car(null, "Logan", c9, "SAFSME32", "Preto");
	Car car3 = new Car(null, "Golf GTI", c2, "SJNFSAEN","Branco");
	Car car4 = new Car(null, "SkyLine", c3,"KSNQI3F", "Azul");
	Car car5 = new Car(null, "Jetta", c4,"JSDSVC1", "Cinza");
	Car car6 = new Car(null, "Onix", c5,"4USDYE7XA", "Branco");
	Car car7 = new Car(null, "Subaru", c6,"CDQ3CSK", "Vermelho");
	Car car8 = new Car(null, "Uno", c7,"VCXM9DS", "Branco");
	Car car9 = new Car(null, "911s", c8,"RSA924JS", "Vermelho");

	clientRepo.saveAll(Arrays.asList(c1));
	clientRepo.saveAll(Arrays.asList(c2));
	clientRepo.saveAll(Arrays.asList(c3));
	clientRepo.saveAll(Arrays.asList(c4));
	clientRepo.saveAll(Arrays.asList(c5));
	clientRepo.saveAll(Arrays.asList(c6));
	clientRepo.saveAll(Arrays.asList(c7));
	clientRepo.saveAll(Arrays.asList(c8));
		clientRepo.saveAll(Arrays.asList(c9));
	carRepo.saveAll(Arrays.asList(car1, car2, car3, car4,car5,car6,car7,car8,car9));

	Vacancy va = new Vacancy(null, car3.getId(),"12:00:00", "13:00:00");
	Vacancy va2 = new Vacancy(null, car1.getId(),"11:00:00", "12:00:00");
	Vacancy va3 = new Vacancy(null, car4.getId(),"12:00:00", "15:00:00");
	Vacancy va4 = new Vacancy(null, car2.getId(), "08:00:00", "12:00:00");
	Vacancy va5 = new Vacancy(null, car5.getId(), "13:00:00", "16:00:00");
	Vacancy va6 = new Vacancy(null, car6.getId(), "07:00:00", "11:00:00");
	Vacancy va7 = new Vacancy(null, car7.getId(), "08:00:00", "12:00:00");
	Vacancy va8 = new Vacancy(null, car8.getId(), "06:00:00", "11:00:00");
	Vacancy va9 = new Vacancy(null, car9.getId(), "09:00:00", "11:00:00");




	vacaRepo.saveAll(Arrays.asList(va, va2, va3, va4, va5, va6, va7, va8, va9));


	}

}
