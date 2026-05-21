package com.jmgr.spring_batch_chunks.reader;

import org.springframework.batch.infrastructure.item.xml.StaxEventItemReader;
import org.springframework.batch.infrastructure.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import com.jmgr.spring_batch_chunks.model.Student;

@Component
public class XmlItemReader {

    public StaxEventItemReader<Student> readXmlItemReader() {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Student.class);

        return new StaxEventItemReaderBuilder<Student>()
                .name("studentXmlReader")
                .resource(new FileSystemResource("C:\\proyectos\\Java\\Batch\\spring-batch-chunks\\InputFiles\\students.xml"))
                .addFragmentRootElements("student")
                .unmarshaller(marshaller)
                .build();
    }

}
