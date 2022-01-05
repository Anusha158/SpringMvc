package com.telusko.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Developer {
	
	@Id
	private int devId;
	public int getDevId() {
		return devId;
	}
	public void setDevId(int devId) {
		this.devId = devId;
	}
	private String skill;
	private String tool;
	
	public String getTool() {
		return tool;
	}
	public void setTool(String tool) {
		this.tool = tool;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "Developer [tool=" + tool + ", DevId=" + devId + ", skill=" + skill + "]";
	}

}
