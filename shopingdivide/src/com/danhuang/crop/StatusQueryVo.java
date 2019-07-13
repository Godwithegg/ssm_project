package com.danhuang.crop;

import java.util.List;

public class StatusQueryVo {
	private Status status;
	private StatusCustom statusCustom;
	
	private List<StatusCustom> statusList;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public StatusCustom getStatusCustom() {
		return statusCustom;
	}

	public void setStatusCustom(StatusCustom statusCustom) {
		this.statusCustom = statusCustom;
	}

	public List<StatusCustom> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<StatusCustom> statusList) {
		this.statusList = statusList;
	}
	     
}
