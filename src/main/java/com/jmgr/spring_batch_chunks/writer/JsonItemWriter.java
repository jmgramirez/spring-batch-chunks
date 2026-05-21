package com.jmgr.spring_batch_chunks.writer;

import org.springframework.batch.infrastructure.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.infrastructure.item.json.JsonFileItemWriter;
import org.springframework.batch.infrastructure.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.jmgr.spring_batch_chunks.model.Student;

@Component
public class JsonItemWriter {

    public JsonFileItemWriter<Student> writerJsonItemWriter() {

        return new JsonFileItemWriterBuilder<Student>()
                .name("studentJsonWriter")
                .resource(new FileSystemResource("C:\\proyectos\\Java\\Batch\\spring-batch-chunks\\OutputFiles\\students-output.json"))
                .jsonObjectMarshaller(new JacksonJsonObjectMarshaller<>())
                .encoding("UTF-8")
                .shouldDeleteIfExists(true)   // 🔥 sobrescribe archivo
                .append(false)                // no agrega al final
                .build();
    }

}
