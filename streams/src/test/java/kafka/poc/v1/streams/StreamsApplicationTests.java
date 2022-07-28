package kafka.poc.v1.streams;

import org.apache.catalina.LifecycleState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class StreamsApplicationTests {

    @Autowired
    KafkaProducer kafkaProducer;

    @Test
    void contextLoads() {
        List<String> aaa = new ArrayList<>();
        aaa.add("test_1");
        aaa.add("poc");
        aaa.add("tesla");

        aaa.forEach(value -> {
            for (int i =0 ; i< 100; i ++) {
                kafkaProducer.sendMessage(value);
            }
        });

    }

}
