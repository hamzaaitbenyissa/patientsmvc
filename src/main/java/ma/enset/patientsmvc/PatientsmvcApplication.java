package ma.enset.patientsmvc;

import com.github.javafaker.Faker;
import ma.enset.patientsmvc.entities.Patient;
import ma.enset.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class PatientsmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsmvcApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){

        return  args ->{

            Faker faker = new Faker();
            Random rd = new Random();
            for (int i = 0; i < 20; i++) {
                patientRepository.save(new Patient(null,faker.name().name(),faker.date().birthday(), rd.nextBoolean(),rd.nextInt(100)));
            }
        };
    }
}
