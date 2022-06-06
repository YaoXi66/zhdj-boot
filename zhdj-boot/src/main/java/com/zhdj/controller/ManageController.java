package com.zhdj.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhdj.bean.*;
import com.zhdj.dao.*;
import com.zhdj.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping("/manage")
public class ManageController {
    @Resource
    private ManageService manageService;

    @Resource
    private BookDao bookDao;
    @Resource
    private DynamicDao dynamicDao;
    @Resource
    private VrDao vrDao;
    @Resource
    private UserDao userDao;
    @Resource
    private FeedBackDao feedBackDao;
    @Resource
    private CommunicationDao communicationDao;
    @Resource
    private CourseDao courseDao;
    @Resource
    private ExamDao examDao;
    @Resource
    private MessageDao messageDao;

/*-------------------------------------------------增加--------------------------------------------------------*/

    //    创建图书
    @RequestMapping("/insert/book")
    public void insertBooks(@RequestBody Map<String,Object> book, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object data = book.get("data");
        System.out.println(data);
        Book books=new Book();
        List<Book> parse =JSON.parseArray(data.toString(),Book.class);
        for (Book book1 : parse) {
            books.setBook_id(book1.getBook_id());
            books.setAuthor(book1.getAuthor());
            books.setImg_src(book1.getImg_src());
            books.setIntroduce(book1.getIntroduce());
            books.setTitle(book1.getTitle());
            System.out.println(books);
//            manageService.insertBook(books);
            bookDao.insert(books);
        }
    }

//    创建党务动态
    @RequestMapping("/insert/dynamic")
    public void insertDynamic(@RequestBody Map<String,Object> Dynamic, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object data = Dynamic.get("data");
        System.out.println(data);

        Dynamic dynamic = new Dynamic();
        List<Dynamic> parse =JSON.parseArray(data.toString(),Dynamic.class);
        for (Dynamic dynamic1 : parse) {
            dynamic.setId(dynamic1.getId());
            dynamic.setUser_id(dynamic1.getUser_id());
            dynamic.setTime(dynamic1.getTime());
            dynamic.setType(dynamic1.getType());
            dynamic.setLink(dynamic1.getLink());
            dynamic.setTitle(dynamic.getTitle());
            dynamic.setPreview(dynamic.getPreview());

            System.out.println(dynamic);
            dynamicDao.insert(dynamic);
        }

    }

//    创建VR
    @RequestMapping("/insert/vrList")
    public void insertVr(@RequestBody Map<String,Object> Vr, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object data = Vr.get("data");
        System.out.println(data);
        Vr vr = new Vr();
        List<Vr> parse =JSON.parseArray(data.toString(),Vr.class);
        for (Vr vr1 : parse) {
            vr.setId(vr1.getId());
            vr.setUrl(vr1.getUrl());
            vr.setName(vr1.getName());
            vr.setPreview(vr1.getPreview());
            vr.setImg_url(vr1.getImg_url());
            System.out.println(vr);
            vrDao.insert(vr);

        }

    }

//    添加User
    @RequestMapping("/insert/user")
    public void insertUser(@RequestBody Map<String,Object> User, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object data = User.get("data");
        System.out.println(data);
        User user = new User();
        List<User> parse =JSON.parseArray(data.toString(),User.class);
        for (User user1 : parse) {
            user.setId(user1.getId());
            user.setName(user1.getName());
            user.setPassword(user1.getPassword());
            user.setEmail(user1.getEmail());
            user.setSex(user1.getSex());
            user.setGrade_id(user1.getGrade_id());
            user.setBg_img(user1.getBg_img());
            user.setHeader_img(user1.getHeader_img());
            System.out.println(user1);
            userDao.insert(user);

        }

    }

//    创建Message
    @RequestMapping("/insert/message")
    public void insertMessage(@RequestBody Map<String,Object> Message, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object data = Message.get("data");
        System.out.println(data);
        Message message = new Message();
        List<Message> parse =JSON.parseArray(data.toString(),Message.class);
        for (Message message1 : parse) {
            message.setUser_id(message1.getUser_id());
            message.setSender_id(message1.getSender_id());
            message.setContent(message1.getContent());
            message.setTime(message1.getTime());
            message.setMessage_id(message1.getMessage_id());
            System.out.println(message);
            messageDao.insert(message);

        }

    }

//    创建会议
    @RequestMapping("/insert/metting")
    public void insertMeeting(@RequestBody Map<String,Object> Course, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object data = Course.get("data");
        System.out.println(data);
        Course course = new Course();
        List<Course> parse =JSON.parseArray(data.toString(),Course.class);
        for (Course course1 : parse) {
            course.setId(course1.getId());
            course.setName(course1.getName());
            course.setNumber(course1.getNumber());
            course.setMan(course1.getMan());
            course.setLink(course1.getLink());
            course.setTime(course1.getTime());
            System.out.println(course);
            courseDao.insert(course);

        }

    }

/*-------------------------------------------------修改--------------------------------------------------------*/

//    修改图书
    @RequestMapping("/update/book")
    public void updateBook(@RequestBody Map<String,Object> data, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object books = data.get("data");
        System.out.println(books);
        Book book = JSON.parseObject(books.toString(), Book.class);

        Book book1 = new Book();
        book1.setBook_id(book.getBook_id());
        book1.setTitle(book.getTitle());
        book1.setIntroduce(book.getIntroduce());
        book1.setAuthor(book.getAuthor());
        book1.setImg_src(book.getImg_src());
        System.out.println(book1);

        bookDao.updateById(book1);

    }

//    修改用户
    @RequestMapping("/update/user")
    public void updateUser(@RequestBody Map<String,Object> data, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object user2 = data.get("data");
        System.out.println(user2);
        User user = JSON.parseObject(user2.toString(), User.class);
        User user1 = new User();

        user1.setId(user.getId());
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setSex(user.getSex());
        user1.setHeader_img(user.getHeader_img());


        System.out.println(user1);

        userDao.updateById(user1);

    }

//    修改vr
    @RequestMapping("/update/vr")
    public void updateVr(@RequestBody Map<String,Object> data, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(data);
        Object vrs = data.get("data");
        System.out.println(vrs);
        Vr vr1 = JSON.parseObject(vrs.toString(), Vr.class);
        Vr vr = new Vr();
        vr.setId(vr1.getId());
        vr.setUrl(vr1.getUrl());
        vr.setName(vr1.getName());
        vr.setPreview(vr1.getPreview());

        System.out.println(vr);

        vrDao.updateById(vr);

    }

//    修改metting
    @RequestMapping("/update/metting")
    public void updateMetting(@RequestBody Map<String,Object> data, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(data);
        Object courses = data.get("data");
        System.out.println(courses);
        Course course1 = JSON.parseObject(courses.toString(), Course.class);

        Course course = new Course();
        course.setId(course1.getId());
        course.setName(course1.getName());
        course.setNumber(course1.getNumber());
        course.setMan(course1.getMan());
        course.setLink(course1.getLink());
        course.setTime(course1.getTime());

        System.out.println(course);

        courseDao.updateById(course);

    }

//    修改题库
    @RequestMapping("/update/exam")
    public void updateExam(@RequestBody Map<String,Object> data, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object exams = data.get("data");
        Exam exam1 = JSON.parseObject(exams.toString(), Exam.class);

        Exam exam = new Exam();
        exam.setId(exam1.getId());
        exam.setName(exam1.getName());
        exam.setUrl(exam1.getUrl());
        exam.setPerview(exam1.getPerview());

        System.out.println(exam);

        examDao.updateById(exam);

    }

/*-------------------------------------------------删除--------------------------------------------------------*/
//    删除用户
    @RequestMapping("/delete/user")
    public void deleteUser(Integer id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(id);
        userDao.deleteById(id);

    }

//    删除反馈
    @RequestMapping("/delete/feedback")
    public void deleteFeedback(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //结合Map实现删除的条件
        Map<String,Object> conditionsMap=new HashMap<>();
        conditionsMap.put("user_id",id);
        feedBackDao.deleteByMap(conditionsMap);

    }

//    删除动态new
    @RequestMapping("/delete/news")
    public void deleteNews(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(id);
        dynamicDao.deleteById(id);

    }

//    删除心声
    @RequestMapping("/delete/heart")
    public void deleteHeart(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(id);
        communicationDao.deleteById(id);

    }

//    删除图书
    @RequestMapping("/delete/book")
    public void deleteBook(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(id);
        bookDao.deleteById(id);

    }

//    删除Vr
    @RequestMapping("/delete/vr")
    public void deleteVr(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(id);
        vrDao.deleteById(id);

    }

//    删除题库
    @RequestMapping("/delete/bank")
    public void deleteBank(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(id);
        examDao.deleteById(id);

    }

//    删除会议
    @RequestMapping("/delete/meeting")
    public void deleteMeeting(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(id);
        courseDao.deleteById(id);

    }

//    删除消息
    @RequestMapping("/delete/message")
    public void deleteMessage(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(id);
        messageDao.deleteById(id);

    }

/*-------------------------------------------------查询--------------------------------------------------------*/

    //    查询user
    @RequestMapping("/select/Alluser")
    public void selectUser( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = userDao.selectList(null);
        System.out.println(users);

        //可以使用封装类简写Content-Type，使用该方法则无需使用setCharacterEncoding
        response.setContentType("text/html;charset=UTF-8");

        JSONObject res = new JSONObject();
        res.put("data",users);
        res.put("result",200);
        System.out.println(res.toJSONString());
        response.getWriter().write(res.toJSONString());


    }

//    查询反馈
    @RequestMapping("/select/AllFeedBack")
    public void selectFeedBack( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<FeedBack> feedBacks = feedBackDao.selectList(null);
        System.out.println(feedBacks);

        //可以使用封装类简写Content-Type，使用该方法则无需使用setCharacterEncoding
        response.setContentType("text/html;charset=UTF-8");

        JSONObject res = new JSONObject();
        res.put("data",feedBacks);
        res.put("result",200);
        System.out.println(res.toJSONString());
        response.getWriter().write(res.toJSONString());

    }

//    查询动态news
    @RequestMapping("/select/AllNews")
    public void selectNews( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Dynamic> dynamics = dynamicDao.selectList(null);
        System.out.println(dynamics);

        //可以使用封装类简写Content-Type，使用该方法则无需使用setCharacterEncoding
        response.setContentType("text/html;charset=UTF-8");

        JSONObject res = new JSONObject();
        res.put("data",dynamics);
        res.put("result",200);
        System.out.println(res.toJSONString());
        response.getWriter().write(res.toJSONString());

    }

 //    查询心声
    @RequestMapping("/select/AllHeart")
    public void selectHeart( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Communication> communications = communicationDao.selectList(null);
        System.out.println(communications);

        //可以使用封装类简写Content-Type，使用该方法则无需使用setCharacterEncoding
        response.setContentType("text/html;charset=UTF-8");

        JSONObject res = new JSONObject();
        res.put("data",communications);
        res.put("result",200);
        System.out.println(res.toJSONString());
        response.getWriter().write(res.toJSONString());

    }


//    查询图书
    @RequestMapping("/select/book")
    public void selectBook( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> books = bookDao.selectList(null);
        System.out.println(books);

        //可以使用封装类简写Content-Type，使用该方法则无需使用setCharacterEncoding
        response.setContentType("text/html;charset=UTF-8");

        JSONObject res = new JSONObject();
        res.put("data",books);
        res.put("result",200);
        System.out.println(res.toJSONString());
        response.getWriter().write(res.toJSONString());

    }


//    查询Vr
    @RequestMapping("/select/vr")
    public void selectVr( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Vr> vrs = vrDao.selectList(null);
        System.out.println(vrs);

        //可以使用封装类简写Content-Type，使用该方法则无需使用setCharacterEncoding
        response.setContentType("text/html;charset=UTF-8");

        JSONObject res = new JSONObject();
        res.put("data",vrs);
        res.put("result",200);
        System.out.println(res.toJSONString());
        response.getWriter().write(res.toJSONString());

    }

//    查询题库
    @RequestMapping("/select/bank")
    public void selectBank( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Exam> exams = examDao.selectList(null);
        System.out.println(exams);

        //可以使用封装类简写Content-Type，使用该方法则无需使用setCharacterEncoding
        response.setContentType("text/html;charset=UTF-8");

        JSONObject res = new JSONObject();
        res.put("data",exams);
        res.put("result",200);
        System.out.println(res.toJSONString());
        response.getWriter().write(res.toJSONString());

    }

//    查询题库
    @RequestMapping("/select/meeting")
    public void selectMeeting( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Course> courses = courseDao.selectList(null);
        System.out.println(courses);

        //可以使用封装类简写Content-Type，使用该方法则无需使用setCharacterEncoding
        response.setContentType("text/html;charset=UTF-8");

        JSONObject res = new JSONObject();
        res.put("data",courses);
        res.put("result",200);
        System.out.println(res.toJSONString());
        response.getWriter().write(res.toJSONString());

    }

    //    查询题库
    @RequestMapping("/select/message")
    public void selectMessage( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Message> messages= messageDao.selectList(null);
        System.out.println(messages);

        //可以使用封装类简写Content-Type，使用该方法则无需使用setCharacterEncoding
        response.setContentType("text/html;charset=UTF-8");

        JSONObject res = new JSONObject();
        res.put("data",messages);
        res.put("result",200);
        System.out.println(res.toJSONString());
        response.getWriter().write(res.toJSONString());

    }

}
