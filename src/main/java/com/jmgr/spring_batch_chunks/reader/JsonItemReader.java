package com.jmgr.spring_batch_chunks.reader;

import org.springframework.batch.infrastructure.item.json.JacksonJsonObjectReader;
import org.springframework.batch.infrastructure.item.json.builder.JsonItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.jmgr.spring_batch_chunks.model.Student;

@Component
public class JsonItemReader {

    public org.springframework.batch.infrastructure.item.json.JsonItemReader<Student> read() {
        return new JsonItemReaderBuilder<Student>()
                .name("studentJsonItemReader")
                .resource(new FileSystemResource("C:\\proyectos\\Java\\Batch\\spring-batch-chunks\\InputFiles\\students.json"))
                .jsonObjectReader(new JacksonJsonObjectReader<>(Student.class))
                .build();
    }


}
