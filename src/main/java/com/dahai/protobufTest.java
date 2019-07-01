package com.dahai;

public class protobufTest {
    public static void main(String[] args) throws Exception{
        PersonModel.Person.Builder builder = PersonModel.Person.newBuilder();
        builder.setId(1);
        builder.setName("陈海洋");
        PersonModel.Person person = builder.build();
        System.out.println("before:"+person);
        for(byte b : person.toByteArray()){
            System.out.println(b);
        }
        byte[] byteArray = person.toByteArray();
        PersonModel.Person p2 = PersonModel.Person.parseFrom(byteArray);
        System.out.println("after id:" + p2.getId());
        System.out.println("after name:" + p2.getName());
        System.out.println("after email:" + p2.getEmail());
    }
}
