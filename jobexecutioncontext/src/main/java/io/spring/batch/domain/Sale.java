/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.spring.batch.domain;

import java.util.Date;

/**
 * @author Michael Minella
 */
public class Sale {

	private final String region;
	private final String country;
	private final String itemType;
	private final String SalesChannel;
	private final String orderPriority;
	private final String orderDate;
	private final String orderID;
	private final String shipDate;
	private final String unitsSold;
	private final String unitPrice;
	private final String unitCost;
	private final String totalRevenue;
	private final String totalCost;
	private final String totalProfit;

	public Sale(String region, String country, String itemType, String salesChannel, String orderPriority,
			String orderDate, String orderID, String shipDate, String unitsSold, String unitPrice, String unitCost,
			String totalRevenue, String totalCost, String totalProfit) {
		super();
		this.region = region;
		this.country = country;
		this.itemType = itemType;
		SalesChannel = salesChannel;
		this.orderPriority = orderPriority;
		this.orderDate = orderDate;
		this.orderID = orderID;
		this.shipDate = shipDate;
		this.unitsSold = unitsSold;
		this.unitPrice = unitPrice;
		this.unitCost = unitCost;
		this.totalRevenue = totalRevenue;
		this.totalCost = totalCost;
		this.totalProfit = totalProfit;
	}

	@Override
	public String toString() {
		return "Sale [region=" + region + ", country=" + country + ", itemType=" + itemType + ", SalesChannel="
				+ SalesChannel + ", orderPriority=" + orderPriority + ", orderDate=" + orderDate + ", orderID="
				+ orderID + ", shipDate=" + shipDate + ", unitsSold=" + unitsSold + ", unitPrice=" + unitPrice
				+ ", unitCost=" + unitCost + ", totalRevenue=" + totalRevenue + ", totalCost=" + totalCost
				+ ", totalProfit=" + totalProfit + "]";
	}

}
