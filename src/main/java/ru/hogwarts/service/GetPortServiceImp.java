package ru.hogwarts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.hogwarts.model.Student;
import ru.hogwarts.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
@Profile("production")
public class GetPortServiceImp implements GetPortService {
    private Logger logger = LoggerFactory.getLogger(GetPortServiceImp.class);

    @Value("${server.port}")
    private Integer port;
    private final StudentRepository studentRepository;

    public GetPortServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Integer getPort() {
        logger.info("Was invoked method for get port");
        return port;
    }

    @Override
    public Integer triangularNumber(Integer triangularNumber) {
        long start = System.currentTimeMillis();
        Integer sum = getSum(triangularNumber);
        long finish = System.currentTimeMillis();
        long time = start - finish;
        logger.info("Was invoked method for get sum {}", time);
        return sum;
    }


    private Integer getSum(Integer sum) {
      return Stream.iterate(1, a -> a +1) .limit(sum) .reduce(0, (a, b) -> a + b );
    }
}
