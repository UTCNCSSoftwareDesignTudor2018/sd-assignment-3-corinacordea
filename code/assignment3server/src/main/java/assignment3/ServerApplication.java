package assignment3;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import assignment3.business.service.ArticleService;
import assignment3.communication.Server;

@SpringBootApplication
public class ServerApplication  implements CommandLineRunner{
	@Autowired
	Server server;
	@Autowired
	ArticleService as;
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		try {
		server.startServer();	
		}catch(HibernateException exception){
		     exception.printStackTrace();
		}
	}
}
