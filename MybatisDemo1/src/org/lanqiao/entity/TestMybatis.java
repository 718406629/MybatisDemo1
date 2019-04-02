package org.lanqiao.entity;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMybatis {
  //查询单个人
  public static void queryPersonById() throws IOException {
	  
		// 加载MyBatis配置文件（为了访问数据库）
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// SqlSessionFactory - connection
		
		SqlSession session = sessionFactory.openSession();
		String statement="org.lanqiao.entity.PersonMapper."+"queryPersonById";
		Person person= session.selectOne(statement,2);
		session.commit();
		System.out.println(person);
		session.close();
	  
  }
  
	//查询全部
  public static void queryAllPerson() throws IOException {
	  
		// 加载MyBatis配置文件（为了访问数据库）
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// SqlSessionFactory - connection
		
		SqlSession session = sessionFactory.openSession();
		String statement="org.lanqiao.entity.PersonMapper."+"queryAllPerson";
        List<Person> persons =session.selectList(statement);
        session.commit();
	    System.out.println(persons);
	    session.close();
}
  //根据学号修改
  public static void updatePersonById() throws IOException {
	  
		// 加载MyBatis配置文件（为了访问数据库）
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// SqlSessionFactory - connection
		
		SqlSession session = sessionFactory.openSession();
		String statement="org.lanqiao.entity.PersonMapper."+"updatePersonById";
        Person person=new Person(1,"zl",26);
        int count= session.update(statement, person);
        session.commit();
        System.out.println("修改"+count+"个人");
        session.close();
        
	  
}
  //根据学号删除
  public static void deletePersonById() throws IOException {
	  
		// 加载MyBatis配置文件（为了访问数据库）
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// SqlSessionFactory - connection
		
		SqlSession session = sessionFactory.openSession();
		String statement="org.lanqiao.entity.PersonMapper."+"deletePersonById";
        int count=session.delete(statement,3);
        session.commit();
        System.out.println("删除"+count+"个");
        session.close();
        
	  
}
//添加
  public static void addPerson() throws IOException {
	  
		// 加载MyBatis配置文件（为了访问数据库）
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// SqlSessionFactory - connection
		
		SqlSession session = sessionFactory.openSession();
		String statement="org.lanqiao.entity.PersonMapper."+"addPerson";
        Person person=new Person(3,"ww",25);
       int count= session.insert(statement,person);
       session.commit();//提交事务
       System.out.println("增加"+count+"个人");
	   session.close();
}
  
  
	public static void main(String[] args) throws IOException {
	
		//addPerson();
		//queryAllPerson();
		deletePersonById();
		//queryAllPerson();
		//addPerson();
		
		
	}

}
