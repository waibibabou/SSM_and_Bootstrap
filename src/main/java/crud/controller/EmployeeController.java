package crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import crud.bean.Employee;
import crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//处理员工crud请求
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    /**
     * 查询员工数据
     * @return
     */
    @RequestMapping(value = "/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1")int pn, Model model){

        PageHelper.startPage(pn,5);
        List<Employee> emps=employeeService.getAll();
        PageInfo page=new PageInfo(emps,5);
        model.addAttribute("pageInfo",page);
        return "list";
    }


}
