package com.wealth.builder.vo;

import java.io.Serializable;
import java.util.Date;


public class Tip implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4346249815100462837L;

	public static final String ENTITY_NAME_TIP = "TIP";

	private long tipId;

	public static final String STOCK_NAME="STOCK_NAME";
	private String stockName;
	
	public static final String STATUS="STATUS";
	private String status;
	
	public static final String TIP="TIP";
	private String tip;
	
	public static final String TIP_NEW_LINE="TIP_NEW_LINE";
	private String newlyAddedLine;
	
	public static final String PROFIT="PROFIT";
	private String profit;
	
	public static final String CREATED_DATE="CREATED_DATE";
	private Date createdDate;
	
	public static final String UPDATED_DATE="UPDATED_DATE";
	private Date updatedDate;
	
	public static final String NEW_LINE_ADDED_DATE="NEW_LINE_ADDED_DATE";
	private Date newLineAddedDate;
	
	public static final String PROFILE="PROFILE";
	private String profile;

	public long getTipId() {
		return tipId;
	}

	public void setTipId(long tipId) {
		this.tipId = tipId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getNewlyAddedLine() {
		return newlyAddedLine;
	}

	public void setNewlyAddedLine(String newlyAddedLin) {
		this.newlyAddedLine = newlyAddedLin;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getNewLineAddedDate() {
		return newLineAddedDate;
	}

	public void setNewLineAddedDate(Date newLineAddedDate) {
		this.newLineAddedDate = newLineAddedDate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "Tip [tipId=" + tipId + ", status=" + status + ", tip=" + tip
				+ ", newlyAddedLine=" + newlyAddedLine + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate
				+ ", newLineAddedDate=" + newLineAddedDate + ", profile="
				+ profile + "]";
	}

}
