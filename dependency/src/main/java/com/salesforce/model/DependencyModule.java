package com.salesforce.model;

import java.util.HashSet;
import java.util.Set;

public class DependencyModule {

	private String name;
	private boolean isStandAloneInstalledModule;
	private boolean isInstalled;
	private Set<DependencyModule> dependsOn;
	private Set<DependencyModule> dependedBy;

	public DependencyModule(String name, boolean isStandAloneModule) {
		this.name = name;
		this.isStandAloneInstalledModule = isStandAloneModule;
		this.dependsOn = new HashSet<>();
		this.dependedBy = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStandAloneInstalledModule() {
		return isStandAloneInstalledModule;
	}

	public void setStandAloneInstalledModule(boolean isStandAloneModule) {
		this.isStandAloneInstalledModule = isStandAloneModule;
	}

	public void addDependsOn(DependencyModule module) {
		this.dependsOn.add(module);
	}

	public Set<DependencyModule> getDependsOn() {
		return dependsOn;
	}
	
	public void removeDependsOn(DependencyModule module) {
		this.dependsOn.remove(module);
	}
	
	public boolean isDependentOn(DependencyModule module){
		return this.dependsOn.contains(module);
	}

	public Set<DependencyModule> getDependedBy() {
		return dependedBy;
	}

	public void addDependedBy(DependencyModule module) {
		this.dependedBy.add(module);
	}

	public void removeDependedBy(DependencyModule module) {
		this.dependedBy.remove(module);
	}

	public boolean isDependedBy(DependencyModule module) {
		return this.dependedBy.contains(module);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DependencyModule other = (DependencyModule) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\tName :" + this.name + "\n");
		sb.append("\tisStandAloneModule :" + this.isStandAloneInstalledModule  + "\n");
		sb.append("\tDepends On modules:" + "\n");
		for(DependencyModule module : this.dependsOn)
			sb.append("\t\t" + module.toString()  + "\n");
		return sb.toString();
	}

	public boolean isInstalled() {
		return isInstalled;
	}

	public void setInstalled(boolean isInstalled) {
		this.isInstalled = isInstalled;
	}

}
