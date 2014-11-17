package org.apache.ibatis.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class XmlTester {

    public static void main(String[] args) {

        String resource = "org/apache/ibatis/demo/mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();
            try {
                UserMapper mapper = session.getMapper(UserMapper.class);
                User u = mapper.select(3);
                System.out.println(u);

                User u1 = mapper.selectByName("yangfei");
                System.out.println(u1);

            } finally {
                session.close();
            }
        } catch(Exception e) {System.out.println(e.getMessage());}

        System.out.println("xxxxxxxxxxxxx");
    }
}
