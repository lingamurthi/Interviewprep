package com.lingu.boot.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println("Inside writer");
		System.out.println("Writing Data"+items);
		
	}

}
