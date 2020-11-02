package io.spring.batch.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;

public class SalesWriter implements ItemWriter<Sale>,  StepExecutionListener {

	private JobExecution jobExecution;
	private List<Sale> saleList = new ArrayList<>();
	
	@Override
	public void write(List<? extends Sale> items) throws Exception {
		for (Sale item : items) {
			System.out.println(item.toString());
		}
		List<Sale> sales = (List<Sale>)jobExecution.getExecutionContext().get("items");
		if(sales == null) {
			saleList.addAll(items);
			jobExecution.getExecutionContext().put("items", saleList);
		} else {
			saleList.addAll(items);
			jobExecution.getExecutionContext().put("items", saleList);
		}
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println(stepExecution);
		List<Sale> sales = (List<Sale>) jobExecution.getExecutionContext().get("items");
		System.out.println(sales.size());
        return stepExecution.getExitStatus();
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		 System.out.println(stepExecution);
		 jobExecution = stepExecution.getJobExecution();
	}

}
