package com.jmgr.spring_batch_chunks.writer;

import org.springframework.batch.infrastructure.item.xml.StaxEventItemWriter;
import org.springframework.batch.infrastructure.item.xml.builder.StaxEventItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import com.jmgr.spring_batch_chunks.model.Student;

@Component
public class XmlItemWriter {

    public StaxEventItemWriter<Student> writeXmlItemWriter() {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Student.class);

        return new StaxEventItemWriterBuilder<Student>()
                .name("studentXmlWriter")
                .resource(new FileSystemResource("C:\\proyectos\\Java\\Batch\\spring-batch-chunks\\OutputFiles\\students-output.xml"))
                .marshaller(marshaller)
                .rootTagName("students")
                .encoding("UTF-8")
                .overwriteOutput(true)        // 🔥 sobrescribe archivo
                .build();
    }

}
