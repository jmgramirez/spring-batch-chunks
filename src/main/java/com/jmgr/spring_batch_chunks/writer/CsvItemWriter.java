package com.jmgr.spring_batch_chunks.writer;

import org.springframework.batch.infrastructure.item.file.FlatFileItemWriter;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.jmgr.spring_batch_chunks.model.Student;

@Component
public class CsvItemWriter {

    public FlatFileItemWriter<Student> writeCsvItemWriter() {
        return new FlatFileItemWriterBuilder<Student>()
                .name("studentCsvWriter")
                .resource(new FileSystemResource("C:\\proyectos\\Java\\Batch\\spring-batch-chunks\\OutputFiles\\students-output.csv"))
                .encoding("UTF-8")
                .delimited()
                .delimiter(",")
                .names("id", "firstName", "lastName", "email")
                .headerCallback(writer -> writer.write("ID,FIRST NAME,LAST NAME,EMAIL"))
                .build();
    }
}
