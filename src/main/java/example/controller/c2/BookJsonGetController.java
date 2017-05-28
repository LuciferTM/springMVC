package example.controller.c2;

import example.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/json")
public class BookJsonGetController {

    @RequestMapping(value="/book/get")
    // @ResponseBody会将集合数据转换json格式返回客户端
    @ResponseBody
    public Object getJson() {
        List<Book> list = new ArrayList<Book>();
        list.add(new Book(1,"Spring MVC企业应用实战","肖文吉"));
        list.add(new Book(2,"轻量级JavaEE企业应用实战","李刚"));
        return list;
    }
}