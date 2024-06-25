package com.util;

import java.util.Random;

public class RandomGenerate {
    public static String generateRandomGender() {
        Random random = new Random();
        return random.nextBoolean() ? "男" : "女";
    }

    public static String generateTime() {
        String[] seasons = {"春", "夏", "秋", "冬"};
        Random random = new Random();
        int index = random.nextInt(4); // 生成 0 到 3 之间的随机数
        String time = "2023 " + seasons[index];
        return time;
    }

    public static String generateCourseId() {
        Random random = new Random();
        String[] seasons = {"111", "222", "333", "444", "555", "666"};
        int index = random.nextInt(6); // 生成 0 到 5 之间的随机数
        return seasons[index];
    }

    public static String generatesStudentAge() {
        Random random = new Random();
        int age=random.nextInt(10)+20;
        String ageStr= String.valueOf(age);
        return ageStr;
    }
    public static String generatesTeacherAge() {
        Random random = new Random();
        int age=random.nextInt(30)+20;
        String ageStr= String.valueOf(age);
        return ageStr;
    }
    public static String generateFaculty() {
        Random random = new Random();
        String[] seasons = {"计算机学院", "通信学院", "电气学院", "自动化学院", "光电学院"};
        int index = random.nextInt(5); // 生成 0 到 4 之间的随机数
        return seasons[index];
    }

    public static String generateRandomString(int length, String charset) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charset.length());
            char randomChar = charset.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static String generatePassword() {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int digit = random.nextInt(10); // 生成0-9的随机数
            password.append(digit);
        }

        return password.toString();
    }

    public static String generateClassroomNumber() {
        String PREFIX = "CR";
        int NUMBER_LENGTH = 4;
        Random random = new Random();
        StringBuilder sb = new StringBuilder(PREFIX);

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int digit = random.nextInt(10);  // 生成0到9的随机数字
            sb.append(digit);
        }
        return sb.toString();
    }

}
