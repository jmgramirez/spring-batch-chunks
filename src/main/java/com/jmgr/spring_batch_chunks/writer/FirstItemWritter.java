package com.jmgr.spring_batch_chunks.writer;



import org.springframework.batch.infrastructure.item.Chunk;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.jmgr.spring_batch_chunks.model.Student;

@Component
public class FirstItemWritter implements ItemWriter<Student> {

    @Override
    public void write(Chunk<? extends Student> chunk) throws Exception {
        System.out.println("Dentro del ItemWriter: ");
        chunk.forEach(System.out::println);
    }

}
