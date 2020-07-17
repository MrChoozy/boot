package com.mrchoozy.demoboot;


import com.mrchoozy.demoboot.entity.Person;
import com.mrchoozy.demoboot.entity.Persons;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.*;

@SpringBootApplication
public class DemoBootApplication implements CommandLineRunner {
//	@Autowired
//	private HobbyService hobbyService;
//	@Autowired
//	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(DemoBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person first = new Person("Aleg", new GregorianCalendar(2000, Calendar.JANUARY , 25).getTime());
		Person second = new Person("Ivgeny", new GregorianCalendar(1985, Calendar.APRIL , 13).getTime());
		second.addHobby("fishing", 30);
		second.addHobby("coocing", 70);

		List<Person> listPersons = new ArrayList<>(Arrays.asList(first, second));
		Persons persons = new Persons();
		persons.setList(listPersons);


		File f = new File("test1.xml");


		try (BufferedReader br = new BufferedReader(new FileReader(f))){

			JAXBContext context = JAXBContext.newInstance(Persons.class);
			Marshaller mar= context.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			mar.marshal(persons, new File("test1.xml"));  //сериализация

			StringBuilder result = new StringBuilder();
			String line;
			while((line = br.readLine()) != null){
				result.append(line);
			}

			StringReader reader = new StringReader(result.toString());
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Persons outPersons = (Persons) unmarshaller.unmarshal(reader); //десериализация
            System.out.println(outPersons);

//            for(Person one: outPersons.getList()){
//            	personService.save(one);
//            	if(one.getHobbyes() != null){
//            		for(Hobby hobby: one.getHobbyes()){
//            			hobbyService.save(hobby);
//					}
//				}
//			}

		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}
	private static java.sql.Date convert(java.util.Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}
}