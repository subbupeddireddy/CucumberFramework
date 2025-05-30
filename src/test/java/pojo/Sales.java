package pojo;

import java.util.List;

public class Sales {
	
	
	private String invSubType;
	private String delvOrdNo;
	private String supLocCode;
	private String recLocCode;
	private String invDate;
	private String invNo;
	private String refInvNo;
	private List<ItemInfoSale> itemInfo;
	
	
	private String invoiceType;
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public void setInvSubType(String invSubType) {
		this.invSubType = invSubType;
	}
	public void setDelvOrdNo(String delvOrdNo) {
		this.delvOrdNo = delvOrdNo;
	}
	public void setSupLocCode(String supLocCode) {
		this.supLocCode = supLocCode;
	}
	public void setRecLocCode(String recLocCode) {
		this.recLocCode = recLocCode;
	}
	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	public void setRefInvNo(String refInvNo) {
		this.refInvNo = refInvNo;
	}
	public void setItemInfo(List<ItemInfoSale> itemInfo) {
		this.itemInfo = itemInfo;
	}

	
	

}
