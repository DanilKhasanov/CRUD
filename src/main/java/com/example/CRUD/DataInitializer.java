package com.example.CRUD;

import com.example.CRUD.Entity.Faculty;
import com.example.CRUD.Entity.Group;
import com.example.CRUD.Repository.FacultyRepository;
import com.example.CRUD.Repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final FacultyRepository facultyRepository;
    private final GroupRepository groupRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {

            if (facultyRepository.count() == 0) {

                Faculty itFaculty = new Faculty();
                itFaculty.setName("Информационные технологии");
                facultyRepository.save(itFaculty);

                Faculty economicsFaculty = new Faculty();
                economicsFaculty.setName("Экономика");
                facultyRepository.save(economicsFaculty);

                Group isp101 = new Group();
                isp101.setName("ИСП-101");
                isp101.setFaculty(itFaculty);
                groupRepository.save(isp101);

                Group isp102 = new Group();
                isp102.setName("ИСП-102");
                isp102.setFaculty(itFaculty);
                groupRepository.save(isp102);

                Group ek101 = new Group();
                ek101.setName("ЭК-101");
                ek101.setFaculty(economicsFaculty);
                groupRepository.save(ek101);
            }
        };
    }
}