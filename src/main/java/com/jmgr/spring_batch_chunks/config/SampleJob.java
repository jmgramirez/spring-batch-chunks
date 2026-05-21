package com.jmgr.spring_batch_chunks.config;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.parameters.RunIdIncrementer;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.xml.StaxEventItemReader;
import org.springframework.batch.infrastructure.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.jmgr.spring_batch_chunks.model.Student;
import com.jmgr.spring_batch_chunks.reader.CsvItemReader;
import com.jmgr.spring_batch_chunks.reader.JsonItemReader;
import com.jmgr.spring_batch_chunks.reader.XmlItemReader;
import com.jmgr.spring_batch_chunks.writer.FirstItemWritter;

@Configuration
public class SampleJob {

    @Autowired
    private CsvItemReader csvItemReader;

    @Autowired
    private JsonItemReader jsonItemReader;

    @Autowired
    private XmlItemReader xmlItemReader;

    /*@Autowired
    private FirstItemProcessor firstItemProcessor;*/

    @Autowired
    private FirstItemWritter firstItemWritter;


    @Bean
    public Job SecondJobOrientedChunks(JobRepository jobRepository) throws Exception {
        return new JobBuilder("Job Chunks", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(chunkStep(jobRepository))
                .build();
    }

    public Step chunkStep(JobRepository jobRepository) throws Exception {
        return new StepBuilder("Chunk Step", jobRepository)
                .<Student, Student>chunk(8)
                .reader(csvItemReader.read())
                //.reader(jsonItemReader.read())
                //.reader(xmlItemReader.readXmlItemReader())
                //.processor(firstItemProcessor)
                .writer(firstItemWritter)
                .build();
    }

}