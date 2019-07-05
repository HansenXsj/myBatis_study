package com.luban;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String resources="mybatis.xml";
        Reader reader=null;
        SqlSession session = null;
        try {
            reader=Resources.getResourceAsReader(resources);
            SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
            session=sqlMapper.openSession();
            Person user=session.selectOne("queryById",1);
            System.out.println(user.getUserName());

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();
            }
        }
    }
}
