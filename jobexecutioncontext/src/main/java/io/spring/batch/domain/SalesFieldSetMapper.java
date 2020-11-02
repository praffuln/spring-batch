package io.spring.batch.domain;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class SalesFieldSetMapper implements FieldSetMapper<Sale> {

	@Override
	public Sale mapFieldSet(FieldSet fieldSet) throws BindException {
		return new Sale(fieldSet.readString("Region"),
				fieldSet.readString("Country"),
				fieldSet.readString("Item Type"),
				fieldSet.readString("Sales Channel"),
				fieldSet.readString("Order Priority"),
				fieldSet.readString("Order Date"),
				fieldSet.readString("Order ID"),
				fieldSet.readString("Ship Date"),
				fieldSet.readString("Units Sold"),
				fieldSet.readString("Unit Price"),
				fieldSet.readString("Unit Cost"),
				fieldSet.readString("Total Revenue"),
				fieldSet.readString("Total Cost"),
				fieldSet.readString("Total Profit")
				);
	}
}
