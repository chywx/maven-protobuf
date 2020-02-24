package com.dahai;


import java.util.Arrays;

public class protobufTest {
    public static void main(String[] args) throws Exception{

        PersonModel.Person.Builder builder = PersonModel.Person.newBuilder();
        builder.setId(1);
        builder.setName("陈大海");
        builder.setEmail("1559843332@qq.com");
        PersonModel.Person person = builder.build();
        System.out.println("before:"+person);
        System.out.println("##############");


        for(byte b : person.toByteArray()){
            System.out.println(b);
        }



        byte[] byteArray = person.toByteArray();

        System.out.println(Arrays.toString(byteArray));

        PersonModel.Person p2 = PersonModel.Person.parseFrom(byteArray);
        System.out.println("##############");
        System.out.println("after id:" + p2.getId());
        System.out.println("after name:" + p2.getName());
        System.out.println("after email:" + p2.getEmail());
    }
}
