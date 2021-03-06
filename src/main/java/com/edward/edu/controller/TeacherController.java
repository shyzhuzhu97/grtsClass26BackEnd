package com.edward.edu.controller;


import com.edward.edu.bean.EduLog;
import com.edward.edu.bean.EduTeacher;
import com.edward.edu.service.TeacherService;
import com.edward.edu.vo.EduResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController //ResponseBody+Controller
@CrossOrigin
@RequestMapping("/eduservice/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    //首页随机展示4个讲师
    @RequestMapping("/indexTeacher")
    public EduResult indexTeacher() {
        List<EduTeacher> teacherAll = teacherService.findFourTeacher();
        if (teacherAll == null) {
            return EduResult.error("展示讲师失败");
        }
        return EduResult.ok().data("rows", teacherAll);
    }

    //添加讲师
    @PostMapping("/addTeacher")
    public EduResult addTeacher(@Valid @RequestBody EduTeacher eduTeacher) {
        int count = teacherService.addTeacher(eduTeacher);
        if (count <= 0) {
            return EduResult.error("添加讲师失败");
        }
        return EduResult.ok().data("count", count);
    }


    //删除讲师 逻辑删除】
    @RequestMapping("/deleteTeacherById/{deleteId}")
    public EduResult deleteTeacherById(@PathVariable int deleteId) {
        EduResult result = teacherService.deleteTeacherById(deleteId);
        return result;
    }
    @RequestMapping("/deleteTeacher")
    public EduResult deleteTeacher(@RequestBody List<Integer> ids) { //可能存在批量删除的情况
        int count = teacherService.deleteTeacher(ids);
        if (count <= 0) {
            return EduResult.error("删除讲师失败");
        }
        return EduResult.ok().data("count", count);
    }

    //修改讲师
    @PostMapping("/updateTeacher")
    public EduResult updateTeacher(@Valid @RequestBody EduTeacher eduTeacher) {
        int count = teacherService.updateTeacher(eduTeacher);
        return EduResult.ok().data("count", count);
    }


    @RequestMapping("/conditionPageQuery/{currentPage}/{limit}")     //传入当前页，每页显示条数，讲师查询条件
    public EduResult conditionPageQuery(@PathVariable Integer currentPage, @PathVariable Integer limit, @RequestBody EduTeacher teacher) {
        System.out.println(teacher);
        System.out.println("-----------------");
        EduResult eduResult = teacherService.conditionPageQuery(currentPage, limit, teacher);
        return eduResult; // 返回当前页的讲师集合与总条数
    }


    //上传头像
    @PostMapping("/uploadAvatar")
    public EduResult uploadAvatar(MultipartFile file) {
        EduResult result = teacherService.uploadAvatar(file);
        return result;
    }

    //根据id查找讲师
    @RequestMapping("/findTeacherById/{id}")
    public EduResult findTeacherById(@PathVariable int id) {
        EduResult result = teacherService.findTeacherById(id);
        return result;
    }

    //查找讲师
    @RequestMapping("/findTeacherAll")
    public EduResult findTeacherAll() {
        EduResult result = teacherService.findTeacherAll();
        return result;
    }

    @RequestMapping("/deleteIds")
    public EduResult deleteIds(@RequestBody List<Integer> ids){
        EduResult result = teacherService.deleteIds(ids);
        return result;
    }



}
