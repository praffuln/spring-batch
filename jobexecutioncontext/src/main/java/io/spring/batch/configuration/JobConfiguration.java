package io.spring.batch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import io.spring.batch.domain.Sale;
import io.spring.batch.domain.SalesFieldSetMapper;
import io.spring.batch.domain.SalesWriter;


@Configuration
public class JobConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	
	@Bean
	public FlatFileItemReader<Sale> salesItemReader() {
		FlatFileItemReader<Sale> reader = new FlatFileItemReader<>();

		reader.setLinesToSkip(1);
		reader.setResource(new ClassPathResource("/data/2m Sales Records.csv"));

		DefaultLineMapper<Sale> saleLineMapper = new DefaultLineMapper<Sale>();
		
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setNames(new String[] {"Region", "Country", "Item Type", 
				"Sales Channel", "Order Priority", 
				 "Order Date", "Order ID", "Ship Date",  "Units Sold", "Unit Price", 
				 "Unit Cost", "Total Revenue", "Total Cost", "Total Profit"});
		
		saleLineMapper.setLineTokenizer(tokenizer);
		saleLineMapper.setFieldSetMapper(new SalesFieldSetMapper());
		saleLineMapper.afterPropertiesSet();

		reader.setLineMapper(saleLineMapper);

		return reader;
	}

	
	@Bean
	public ItemWriter<Sale> saleItemWriter() {
		return new  SalesWriter();
	}

	@Bean
	public Step salesStep1() {
		return stepBuilderFactory.get("step1")
				.<Sale, Sale>chunk(10)
				.reader(salesItemReader())
				.writer(saleItemWriter())
				.build();
	}

	@Bean
	public Job job() {
		return jobBuilderFactory.get("job")
				.start(salesStep1())
				.build();
	}
}
