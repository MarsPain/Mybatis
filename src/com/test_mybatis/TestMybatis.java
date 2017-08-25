package com.test_mybatis;
 
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.test_mybatis.Category;
 
public class TestMybatis {
 
    public static void main(String[] args) throws IOException {
    	//根据配置文件mybatis-config.xml得到sqlSessionFactory 
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
        //然后再根据sqlSessionFactory 得到session
        SqlSession session=sqlSessionFactory.openSession();
        
        //最后通过session的selectList方法，调用sql语句listCategory。listCategory这个就是在配置文件Category.xml中那条sql语句设置的id。
        List<Category> cs=session.selectList("listCategory");
        
        //执行完毕之后，得到一个Category集合，遍历即可看到数据。
        for (Category c : cs) {
            System.out.println(c.getName());
        }
         
    }
}