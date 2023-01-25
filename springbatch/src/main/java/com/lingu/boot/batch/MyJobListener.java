package com.lingu.boot.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Job started");

	}

	@Override
	public void afterJob(JobExecution jobExecution) {
     System.out.println("Job Ended"+jobExecution.getStatus().toString());
	}

}
