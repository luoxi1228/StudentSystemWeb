package com.util;

import com.pojo.*;
import com.service.ClassroomService;
import com.service.GradeService;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Random;


@NoArgsConstructor
public class DataGenerate {
    // 随机创建学生
    public static ArrayList<student> ALLstudents = new ArrayList<>();
    public static ArrayList<teacher> ALLteachers = new ArrayList<>();
    public static ArrayList<classroom> ALLclassrooms = new ArrayList<>();
    public static ArrayList<course> ALLcourse = new ArrayList<>();
    public static ArrayList<grade> ALLGrade = new ArrayList<>();
    RandomGenerate R = new RandomGenerate();
    Random random = new Random();
    String surname = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张" +
            "孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎" +
            "鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤" +
            "滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄";
    String lastName = "白初寺念凌寒乔熙北城九黎诗蓝倾璃残霜月如可青琼恨尘世流璃书萱染栀沉湘落羽巧琴若初" +
            "蝶怜初若曼云若离冬彦溪时安易若晴斐颜景月白萍飒言枫亭顾兮飞枫森凉孤烟青瑶梦杭挽心";
    String number = "123456789";

    // 6门课程
    public void generateCourse() {
        course course1 = new course("111", "高等数学");
        course course2 = new course("222", "线性代数");
        course course3 = new course("333", "大学物理");
        course course4 = new course("444", "数据结构");
        course course5 = new course("555", "思想政治");
        course course6 = new course("666", "程序设计");
        ALLcourse.add(course1);
        ALLcourse.add(course2);
        ALLcourse.add(course3);
        ALLcourse.add(course4);
        ALLcourse.add(course5);
        ALLcourse.add(course6);
    }


    //创建班级
    public void generateClass(int classNum, int courseNum) {

        for (int i = 0; i < classNum; i++) {
            int j = i % courseNum;
            String classId;
            String time = R.generateTime();
            if (i < 10) {
                classId = "class_000" + Integer.toString(i);
            } else if (10 <= i && i < 100) {
                classId = "class_00" + Integer.toString(i);
            } else {
                classId = "class_0" + Integer.toString(i);
            }
            String tId = ALLteachers.get(i).getT_id();
            String courseId = ALLcourse.get(j).getCo_id();
            String c_room=RandomGenerate.generateClassroomNumber();
            int s_num=0;
            classroom cl = new classroom(classId, tId, courseId,c_room,s_num, time);
            ALLclassrooms.add(cl);
        }

    }

    // 12个老师
    public void generateTeacher(int teacherNum) {
        for (int i = 0; i < teacherNum; i++) {
            String name = R.generateRandomString(1, surname) + R.generateRandomString(2, lastName);
            String id;
            if (i <= 9)
                id = "T_2021000" + Integer.toString(i);
            else
                id = "T_202100" + Integer.toString(i);
            String gender = R.generateRandomGender();
            String age=RandomGenerate.generatesTeacherAge();
            String faculty=RandomGenerate.generateFaculty();
            String password=RandomGenerate.generatePassword();
            teacher te = new teacher(id,name, gender,age,faculty,password);
            ALLteachers.add(te);
        }

    }

    // 300个学生
    public void generateStudent(int num) {
        for (int i = 0; i < num; i++) {
            String name = R.generateRandomString(1, surname) + R.generateRandomString(1, lastName);
            String sid;
            if (i < 10) {
                sid = "S_2021000" + Integer.toString(i);
            } else if (10 <= i && i < 100) {
                sid = "S_202100" + Integer.toString(i);
            } else {
                sid = "S_20210" + Integer.toString(i);
            }
            String gender = R.generateRandomGender();
            String  age=RandomGenerate.generatesStudentAge();
            String faculty=RandomGenerate.generateFaculty();
            String password=RandomGenerate.generatePassword();
            int grade=0;
            student st = new student(sid,name,gender,age,faculty,password,grade);
            ALLstudents.add(st);
        }
    }

    //为学生生成各科成绩
    public void generateGrade(int classNum) {
        //为学生分配班级,学生不能选上同一门课的两个班
            int courseNum=classNum/2;
            for (int i = 0; i < ALLstudents.size(); i++) {
                student st = ALLstudents.get(i);
                boolean flag=random.nextBoolean();//根据flag的值，学生只能选择前面6个班，或者后面6个班，保证学生不会选择上同一个课程的两个班
                int num= random.nextInt(3)+3;//每个学生的选课数量

                for (int k = 0; k < num; k++) {
                    int usual = random.nextInt(50) + 50;
                    int mid = random.nextInt(50) + 50;
                    int lab = random.nextInt(50) + 50;
                    int exam = random.nextInt(50) + 50;
                    int fin = (int) (usual * 0.1 + mid * 0.2 + lab * 0.3 + exam * 0.4);
                    String c_id="";
                    if(flag) {
                        c_id=ALLclassrooms.get((i + k) % courseNum).getC_id();
                    } else{
                        c_id=ALLclassrooms.get((i + k) % courseNum+6).getC_id();
                    }
                    grade grade = new grade(st.getS_id(), c_id, mid, lab, exam, usual, fin);
                    DataGenerate.ALLGrade.add(grade);
                }
            }
    }


//学生总成绩生成

    public void generateTotalGrade() {
        for (student alLstudent : ALLstudents) {
            int num = 0;
            for (grade grade : ALLGrade) {
                if (grade.getS_id().equals(alLstudent.getS_id())) {
                    num += grade.getFinalGrade();
                }
            }
            alLstudent.setS_grade(num);
        }
    }

    //确定各班级的人数
    public void stuNum(GradeService service1, ClassroomService service2){
        for (int i = 0; i <ALLclassrooms.size() ; i++) {
            String c_id=ALLclassrooms.get(i).getC_id();
            int num=service1.stuNum(c_id);
            service2.updateNum(num,c_id);
        }
    }

}
