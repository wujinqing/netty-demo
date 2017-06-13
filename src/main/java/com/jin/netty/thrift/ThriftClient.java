package com.jin.netty.thrift;

import com.jin.thrift.Person;
import com.jin.thrift.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by wujinqing on 17/6/12.
 */
public class ThriftClient {
    public static void main(String[] args) {
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();

            Person person = client.getPersonByUsername("张三");

            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());

            Person person1 = new Person();

            person1.setName("李四");
            person1.setAge(33);
            person1.setMarried(false);

            client.savePerson(person1);

        }catch (Exception ex)
        {
            throw new RuntimeException( ex.getMessage(), ex);
        }finally
         {
            transport.close();
        }
    }
}
