package com.model;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> studentsList;

    public StudentManager(String path) {
        loadFromFile(path);
    }

    //文件不存在，创建该文件
    private void buildCsvFile(File file) {
        //判断文件父目录是否存在，不存在则创建。
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            boolean success = parent.mkdirs();
            //创建失败，程序无法启动，结束程序
            if (!success) {
                System.err.println("文件父目录无法创建，文件路径出错。");
                System.exit(1);
            }
        }
        //尝试创建Csv文件，并且写入列名称。
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            writer.write("ID,Name,Gender,Age,Phone,Address,Description\n");
        } catch (IOException e) {
            //创建失败，程序结束。
            System.err.println("无法创建数据文件，请检查父目录是否正确。");
            System.exit(1);
        }
    }

    //从CSV文件中加载数据到内存中
    private void loadFromFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            buildCsvFile(file);
        }
        try (Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            studentsList = new CsvToBeanBuilder<Student>(reader)
                    .withType(Student.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        } catch (IOException e) {
            System.err.println("数据加载出错");
            System.exit(1);
        }
    }

    //存储数据到CSV文件中
    public boolean storeToFile(String path) {
        File file = new File(path);
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            StatefulBeanToCsv<Student> beanToCsv = new StatefulBeanToCsvBuilder<Student>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            beanToCsv.write(studentsList);
        } catch (IOException e) {
            System.err.println("请检查输入文件路径，无法保存！！！");
            return false;
        } catch (CsvRequiredFieldEmptyException e) {
            System.err.println("信息不完整，无法写入");
            return false;
        } catch (CsvDataTypeMismatchException e) {
            System.err.println("无法转化为字符串，数据类型错误。");
            return false;
        }
        return true;
    }

    //增加一个学生信息
    public boolean addStudent(Student s) {
        if (s == null || this.studentsList.contains(s)) {
            return false;
        }
        this.studentsList.add(s);
        return true;
    }

    //删除一个学生信息
    public boolean removeStudent(Student s) {
        if (s == null) return false;
        return this.studentsList.remove(s);
    }

    //根据提供的ID删除指定学生信息
    public boolean removeStudentById(String id) {
        if (id == null) {
            return false;
        }
        Student s = new Student(id, "", "", 0, "", "", "");
        return removeStudent(s);
    }

    public Student getStudentById(String id) {
        if (id == null) {
            return null;
        }
        for (Student s : this.studentsList) {
            if (s.getStudentId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public List<Student> getStudentByName(String name) {
        List<Student> list = new ArrayList<>();
        if (name == null) {
            return list;
        }
        for (Student s : this.studentsList) {
            if (s.getName().equals(name)) {
                list.add(s);
            }
        }
        return list;
    }

    public List<Student> getAllStudent() {
        return new ArrayList<>(this.studentsList);
    }
}
