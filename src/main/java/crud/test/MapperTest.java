package crud.test;

import crud.bean.Department;
import crud.bean.Employee;
import crud.dao.DepartmentMapper;
import crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession session;

    @Test
    public void testCRUD(){
        System.out.println(departmentMapper);
        System.out.println(employeeMapper);

//        departmentMapper.insertSelective(new Department(null,"开发部"));
//        departmentMapper.insertSelective(new Department(null,"人力资源部"));

//        employeeMapper.insertSelective(new Employee(null,"zyk","M","111@qq.com",1));

//        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
//        for(int i=0;i<1000;i++){
//            String uuid = UUID.randomUUID().toString().substring(0, 5)+i;
//            mapper.insertSelective(new Employee(null,uuid,"M",uuid+"@qq.com",1));
//        }
//        System.out.println("批量完成");
        List<Employee> list=employeeMapper.selectByExampleWithDept(null);
        for(Employee i:list){
            System.out.println(i);
        }

    }

}
