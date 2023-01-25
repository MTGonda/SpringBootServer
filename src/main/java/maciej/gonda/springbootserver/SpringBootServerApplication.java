package maciej.gonda.springbootserver;

import maciej.gonda.springbootserver.entities.*;
import maciej.gonda.springbootserver.repositories.*;
import maciej.gonda.springbootserver.services.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.sql.Time;



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
    CommandLineRunner run(UserRepo userRepo, RoleRepo roleRepo, DoctorRepo doctorRepo, PatientRepo patientRepo, VisitRepo visitRepo,
                           AllergyRepo allergyRepo, DoctorService doctorService){
        return args->{

//            Specialization alergolog = new Specialization(null,"alergolog", null);
//            specializationRepo.save(alergolog);

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


           // Doctor doctorOne = new Doctor( null, "Jan", "Kowalskil", "123123123","Kosciuszki 3/5", "Alergolog", null, null,userLekarzJanKowalski, null);
           // Doctor doctorTwo = new Doctor(null, "Pawel", "Jumper", "321321321","Stalowa 8", "Alergolog", null,null, userLekarzPawelJumper, null);

            Doctor doctorOne = new Doctor( null, "Jan", "Kowalskil", "123123123","Kosciuszki 3/5","1", "Alergolog", null, null,userLekarzJanKowalski, null);
            Doctor doctorTwo = new Doctor(null, "Pawel", "Jumper", "321321321","Stalowa 8","2", "Alergolog", null,null, userLekarzPawelJumper, null);

            doctorRepo.save(doctorOne);
            doctorRepo.save(doctorTwo);

            Allergy alergiaNaSiersc = new Allergy(null, "Alergia na sierść", "Alergia...", null);
            allergyRepo.save(alergiaNaSiersc);


            Patient patientOne = new Patient(null, "Ewa", "Kowalskap", "666555444","99070255331", new Date(930866400000L).toLocalDate(), null, userPacjenEwaKowalska, null, null, null);
            patientRepo.save(patientOne);



            Visit visit1 = new Visit(null, new Date(1673478000000L),new Time(16,20, 0),new Time(17,20, 0),"Badanie na sierść","...", doctorOne,null,null,null);
            Visit visit2 = new Visit(null, new Date(1674169200000L),new Time(12, 0, 0),new Time(13, 0, 0),"Badanie ", "...",doctorTwo,null,null,null);

            visitRepo.save(visit1);
            visitRepo.save(visit2);

        };
    }
}