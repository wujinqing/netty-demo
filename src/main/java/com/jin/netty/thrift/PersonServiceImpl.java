package com.jin.netty.thrift;

import com.jin.thrift.Person;
import com.jin.thrift.PersonException;
import com.jin.thrift.PersonService;
import org.apache.thrift.TException;

/**
 * Created by wujinqing on 17/6/12.
 */
public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws PersonException, TException {

        System.out.println("got getPersonByUsername...");
        Person person = new Person();

        person.setName(username);
        person.setAge(20);
        person.setMarried(true);

        return person;
    }

    @Override
    public void savePerson(Person person) throws PersonException, TException {
        System.out.println("got savePerson...");
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
