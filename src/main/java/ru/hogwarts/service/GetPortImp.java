package ru.hogwarts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("production")
public class GetPortImp implements GetPort {
    Logger logger = LoggerFactory.getLogger(GetPortImp.class);

    @Value("${server.port}")
    int port;

    @Override
    public Integer getPort() {
        logger.debug("Was invoked method for get port");
        return port;
    }
}
