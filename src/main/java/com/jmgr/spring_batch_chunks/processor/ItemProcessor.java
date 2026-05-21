package com.jmgr.spring_batch_chunks.processor;

import org.springframework.stereotype.Component;

import com.jmgr.spring_batch_chunks.model.Student;

@Component
public class ItemProcessor implements org.springframework.batch.infrastructure.item.ItemProcessor<Student, Student> {

    @Override
    public Student process(Student student) throws Exception {
        System.out.println("Dentro del ItemProcessor: ");

        Student vStudent = new Student();
        vStudent.setEmail(student.getEmail().toUpperCase());
        vStudent.setFirstName(student.getFirstName().toUpperCase());
        vStudent.setId(student.getId());
        vStudent.setLastName(student.getLastName().toUpperCase());

        return vStudent;
        
    }

}
