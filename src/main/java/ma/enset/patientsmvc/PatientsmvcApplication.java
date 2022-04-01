package ma.enset.patientsmvc;

import ma.enset.patientsmvc.entities.Patient;
import ma.enset.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsmvcApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){

        return  args ->{
            patientRepository.save(new Patient(null,"Hassan",new Date(),false,12));
        };
    }
}
