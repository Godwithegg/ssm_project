package com.danhuang.crop;

import java.util.List;

public class KindsQueryVo {
	private Kinds kinds;
	private KindsCustom kindsCustom;
	private List<KindsCustom> customList;
	public Kinds getKinds() {
		return kinds;
	}
	public void setKinds(Kinds kinds) {
		this.kinds = kinds;
	}
	public KindsCustom getKindsCustom() {
		return kindsCustom;
	}
	public void setKindsCustom(KindsCustom kindsCustom) {
		this.kindsCustom = kindsCustom;
	}
	public List<KindsCustom> getCustomList() {
		return customList;
	}
	public void setCustomList(List<KindsCustom> customList) {
		this.customList = customList;
	}
	
}
