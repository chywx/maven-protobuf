package com.dahai;/**
 * @author chy
 * @date 2021/3/4 0004 上午 10:37
 * Description：
 */

import com.dahai.protobuf.PersonModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/3/4 0004
 */
@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/test1")
    public Object test1() {

        PersonModel.Person.Builder builder = PersonModel.Person.newBuilder();
        builder.setId(25);
        builder.setName("chy");
        builder.setEmail("1559843332@qq.com");
        PersonModel.Person person = builder.build();
        System.out.println("before:" + person);
        System.out.println("##############");

        List<byte[]> bytes = new ArrayList<>();
        byte[] byteArray = person.toByteArray();
        bytes.add(byteArray);
        bytes.add(byteArray);
        bytes.add(byteArray);
        return bytes;
    }

    @RequestMapping("/test2")
    public Object test2() {
        PersonModel.Person.Builder builder = PersonModel.Person.newBuilder();
        builder.setId(25);
        builder.setName("chy");
        builder.setEmail("1559843332@qq.com");
        PersonModel.Person person = builder.build();
        System.out.println("before:" + person);

        return person;
    }


}
