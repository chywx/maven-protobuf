package com.dahai;


import com.dahai.protobuf.PersonModel;
import com.dahai.protobuf.SchoolModel;
import com.dahai.protobuf.SchoolModel.School;
import com.dahai.protobuf.SchoolModel.School.Builder;
import com.dahai.protobuf.SchoolModel.Student;
import java.util.Arrays;

public class protobufTest {

    public static void main(String[] args) throws Exception {

        PersonModel.Person.Builder builder = PersonModel.Person.newBuilder();
        builder.setId(23);
        builder.setName("chy");
        builder.setEmail("1559843332@qq.com");
        PersonModel.Person person = builder.build();
        System.out.println("before:" + person);
        System.out.println("##############");

        for (byte b : person.toByteArray()) {
            System.out.println(b);
        }

        byte[] byteArray = person.toByteArray();

        System.out.println(Arrays.toString(byteArray));

        PersonModel.Person p2 = PersonModel.Person.parseFrom(byteArray);
        System.out.println("##############");
        System.out.println("after id:" + p2.getId());
        System.out.println("after name:" + p2.getName());
        System.out.println("after email:" + p2.getEmail());

        System.out.println("--------------------");

        Student s1 = Student.newBuilder()
            .setId(1)
            .setName("hello")
            .setAge(22)
            .build();
        Student s2 = Student.newBuilder()
            .setId(2)
            .setName("hello2")
            .setAge(44)
            .build();
        Builder schoolBuilder = School.newBuilder();
        schoolBuilder.setId(1);
        schoolBuilder.addList(s1);
        schoolBuilder.addList(s2);

        System.out.println(schoolBuilder.toString());


    }
}
