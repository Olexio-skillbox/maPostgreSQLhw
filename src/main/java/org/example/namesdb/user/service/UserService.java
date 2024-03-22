package org.example.namesdb.user.service;

import lombok.AllArgsConstructor;
import org.example.namesdb.user.entity.UserEntity;
import org.example.namesdb.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final NamesGenerator namesGenerator = new NamesGenerator();

    public Boolean init() {
        userRepository.deleteAll();
        int repeat = 10, dataPerLoop = 1000;

        for (int i = 0; i < repeat; i++) {

            List<UserEntity> all = new ArrayList<>();
            for (int dataIndex = 0; dataIndex < dataPerLoop; dataIndex++) {
                NamesGenerator.Name name = namesGenerator.generate();
                UserEntity user = UserEntity.builder()
                        .firstName(name.getFirstName())
                        .lastName(name.getLastName())
                        .build();
                all.add(user);
            }
            userRepository.saveAll(all);
        }
        return true;
    }
}
