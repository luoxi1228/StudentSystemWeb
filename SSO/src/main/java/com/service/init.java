package com.service;

import com.mapper.GradeMapper;
import com.util.DataGenerate;

public class init {
    public static void main(String[] args) {
        StuService stuService = new StuService();
        TeaService teaService = new TeaService();
        CourseService courseService=new CourseService();
        ClassroomService classroomService=new ClassroomService();
        GradeService gradeService=new GradeService();

        DataGenerate dataGenerate = new DataGenerate();
        //清空以前的数据
        stuService.deleteStu();
        teaService.deleteTeacher();
        courseService.deleteCourse();
        classroomService.deleteCourse();
        gradeService.deleteGrade();

        //生成新的数据
        dataGenerate.generateStudent(200);
        dataGenerate.generateTeacher(12);
        dataGenerate.generateCourse();
        dataGenerate.generateClass(12,6);
        dataGenerate.generateGrade(12);



        stuService.initStudent();
        teaService.initTeacher();
        courseService.initCourse();
        classroomService.initCourse();
        gradeService.initGrade();
        stuService.initGrade();

        dataGenerate.stuNum(gradeService,classroomService);
    }
}
