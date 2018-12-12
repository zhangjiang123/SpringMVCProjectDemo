package cn.itcast.controller;


import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model){

        System.out.println("testString方法执行了");

        User user = new User();
        user.setUsername("美美");
        user.setPassword("23");
        user.setAge(12);
        model.addAttribute("user",user);

        return "success";

    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("testString方法执行了");
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
//        response.sendRedirect(request.getContextPath()+"/response.jsp");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().write("hello");
    }

    @RequestMapping("/testModelandView")
    public ModelAndView testString(){

        System.out.println("testString方法执行了");

        ModelAndView mv = new ModelAndView();

        User user = new User();
        user.setUsername("美美");
        user.setPassword("23");
        user.setAge(12);
        mv.addObject("user",user);
        mv.setViewName("success");

        return mv;

    }

    /**
     * 使用关键字请求和转发
     * @return
     */
    @RequestMapping("/testForwardAndRedirect")
    public String testForwardAndRedirect(){

        System.out.println("testForwardAndRedirect方法执行了");



//        return "forward:/WEB-INF/pages/success.jsp";

        return "redirect:/response.jsp";
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){


        System.out.println("testAjax执行了");

        System.out.println(user);
        //查询数据响应
        user.setUsername("haha");
        user.setAge(40);

        return user;

    }

}
