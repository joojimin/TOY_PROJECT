package com.my.toyproject.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class SimpleService {

    private final SimpleTestJpaRepository simpleTestJpaRepository;

    public void saveTest() {
        SimpleTestModel simpleTestModel1 = new SimpleTestModel(1L, "hello world");
        SimpleTestModel saveSimpleTestModel1 = simpleTestJpaRepository.save(simpleTestModel1); // merge
        System.out.println("test1 ==> " + (simpleTestModel1 == saveSimpleTestModel1));

        SimpleTestModel simpleTestModel2 = new SimpleTestModel();
        simpleTestModel2.updateMsg("hello world!!");
        SimpleTestModel saveSimpleTestModel2 = simpleTestJpaRepository.save(simpleTestModel2); // persist
        System.out.println("test2 ==> " + (simpleTestModel2 == saveSimpleTestModel2));
    }
}
