package example.controller.c2;

import example.pojo.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value="/user")
public class UserController{

    // 静态List<User>集合，此处代替数据库用来保存注册的用户信息
    private static List<User> userList;

    // UserController类的构造器，初始化List<User>集合
    public UserController() {
        super();
        userList = new ArrayList<User>();
    }

    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(UserController.class);

    @RequestMapping(value="/register",method= RequestMethod.GET)
    public String registerForm() {
        logger.info("register GET方法被调用...");
        return "registerForm";
    }

    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String register(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password,
            @RequestParam("username") String username) {
        logger.info("register POST方法被调用...");
        // 创建User对象
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        user.setUsername(username);
        // 模拟数据库存储User信息
        userList.add(user);
        // 跳转到登录页面
        return "loginForm";
    }

    // 该方法映射的请求为http://localhost:8080/RequestMappingTest/user/login
    @RequestMapping("/login")
    public String login(
            // 将请求中的loginname参数的值赋给loginname变量,password同样处理
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password,
            Model model) {
        logger.info("登录名:"+loginname + " 密码:" + password);
        // 到集合中查找用户是否存在，此处用来模拟数据库验证
        for(User user : userList){
            if(user.getLoginname().equals(loginname)
                    && user.getPassword().equals(password)){
                model.addAttribute("user",user);
                return "welcome";
            }
        }
        return "loginForm";
    }

}