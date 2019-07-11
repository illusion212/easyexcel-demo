package com.hjw.excel.demo;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.hjw.excel.excle.exception.ExcelException;
import com.hjw.excel.excle.utils.ExcelUtil;
import com.hjw.excel.model.UserModel;
import com.hjw.excel.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {
    private Logger logger=LoggerFactory.getLogger(getClass());

    @RequestMapping("upload")
    public Object upload(MultipartFile file) throws Exception {
//        List<UserModel> list= ExcelUtil.readExcel(file, UserModel.class);
//        List<User> userList= MyBeanCopy.convert(list, User.class);
        List<User> userList= ExcelUtil.readExcel(file, UserModel.class, User.class);
        System.out.println(userList.toString());
        logger.info("aaaaa");
        return "01";
    }

    @RequestMapping("export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws ExcelException {
        UserModel user=new UserModel();
        user.setAge(15);
        user.setName("小米");
        user.setMobile("13112332111");
        List<UserModel> list =new ArrayList<>();
        list.add(user);
        ExcelUtil.writeExcel(response, list,"用户信息表","用户信息", ExcelTypeEnum.XLSX,UserModel.class);
    }

}
