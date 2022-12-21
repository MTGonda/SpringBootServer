package maciej.gonda.springbootserver;

import maciej.gonda.springbootserver.entities.*;
import maciej.gonda.springbootserver.repositories.*;
import maciej.gonda.springbootserver.services.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;

@SpringBootApplication
public class SpringBootServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootServerApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    CommandLineRunner run(UserRepo userRepo, RoleRepo roleRepo, DoctorRepo doctorRepo, PatientRepo patientRepo,
                          SpecializationRepo specializationRepo, AllergyRepo allergyRepo, DoctorService doctorService){
        return args->{

            Specialization alergolog = new Specialization(null,"alergolog", null);
            specializationRepo.save(alergolog);

            Role rolaLekarz = new Role(null, "Lekarz","Rola przypisywana do lekarza");
            Role rolaPacjent = new Role(null, "Pacjent","Rola przypisywana do pacjenta");
            roleRepo.save(rolaLekarz);
            roleRepo.save(rolaPacjent);

            User userLekarzJanKowalski = new User(null,"testLekarz","123",rolaLekarz);
            User userLekarzPawelJumper = new User(null,"lekarzpawel","123",rolaLekarz);
            User userPacjenEwaKowalska = new User(null,"testPacjent","123",rolaPacjent);
            userRepo.save(userLekarzJanKowalski);
            userRepo.save(userLekarzPawelJumper);
            userRepo.save(userPacjenEwaKowalska);

            Doctor doctorOne = new Doctor(null, "Jan", "Kowalskil", "123123123", null, null, userLekarzJanKowalski,null , null);
            Doctor doctorTwo = new Doctor(null, "Pawel", "Jumper", "321321321", null, null, userLekarzPawelJumper,null , null);
            doctorRepo.save(doctorOne);
            doctorRepo.save(doctorTwo);

            Allergy alergiaNaSiersc = new Allergy(null, "Alergia na sierść", "Alergia...", null);
            allergyRepo.save(alergiaNaSiersc);


            Patient patientOne = new Patient(null, "Ewa", "Kowalskap", "666555444","99070255331", new Date(1999,7,2), null, userPacjenEwaKowalska, null, null, null);
            patientRepo.save(patientOne);

        };
    }
}