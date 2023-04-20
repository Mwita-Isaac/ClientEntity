package com.mwita.ClientEntity;

import com.mwita.ClientEntity.model.client;
import com.mwita.ClientEntity.repository.Client_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientEntityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClientEntityApplication.class, args);
	}


	@Autowired
	private Client_Repo Client_Repo;
	@Override
	public void run(String... args) throws Exception {
		client client = new client();
		client.setFirstName("Mwita");
		client.setLastName("Isaac");
		client.setEmailId("julianhurricane8390@gmail.com");
		Client_Repo.save(client);

		client client1 = new client();
		client1.setFirstName("Makene");
		client1.setLastName("Isaac");
		client1.setEmailId("julianhurricane8390@gmail.com");
		Client_Repo.save(client1);
	}
}
