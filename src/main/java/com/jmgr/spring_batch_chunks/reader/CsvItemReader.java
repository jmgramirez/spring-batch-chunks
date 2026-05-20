package com.jmgr.spring_batch_chunks.reader;

import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.infrastructure.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.jmgr.spring_batch_chunks.model.Student;

@Component
public class CsvItemReader {

    public FlatFileItemReader<Student> read() throws Exception {
        System.out.println("Dentro del CsvItemReader: ");
        
        return new FlatFileItemReaderBuilder<Student>()
            .name("studentItemReader")
            .resource(new FileSystemResource("C:\\proyectos\\Java\\Batch\\spring-batch-chunks\\InputFiles\\students.csv"))
            .linesToSkip(1) // Saltar header
            .delimited()
            .delimiter(",")
            .names("id", "firstName", "lastName", "email") // 👈 usar nombres del POJO
            .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                setTargetType(Student.class);
            }})
            .build();
    }

}
