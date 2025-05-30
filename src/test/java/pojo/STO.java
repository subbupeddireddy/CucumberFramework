package pojo;

import java.util.List;

public class STO {
	private String delvOrdNo;
	private String supLocCode;
	private String recLocCode;
	private String delvDate;
	private List<ItemInfoSTO> itemInfo;
	
	public String getDelvOrdNo() {
		return delvOrdNo;
	}
	public void setDelvOrdNo(String delvOrdNo) {
		this.delvOrdNo = delvOrdNo;
	}
	public String getSupLocCode() {
		return supLocCode;
	}
	public void setSupLocCode(String supLocCode) {
		this.supLocCode = supLocCode;
	}
	public String getRecLocCode() {
		return recLocCode;
	}
	public void setRecLocCode(String recLocCode) {
		this.recLocCode = recLocCode;
	}
	public String getDelvDate() {
		return delvDate;
	}
	public void setDelvDate(String delvDate) {
		this.delvDate = delvDate;
	}
	public List<ItemInfoSTO> getItemInfo() {
		return itemInfo;
	}
	public void setItemInfo(List<ItemInfoSTO> itemInfo) {
		this.itemInfo = itemInfo;
	}
	
	

}
