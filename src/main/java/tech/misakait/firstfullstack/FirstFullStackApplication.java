package tech.misakait.firstfullstack;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("tech.misakait.firstfullstack.mapper")
public class FirstFullStackApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstFullStackApplication.class, args);
    }

}
