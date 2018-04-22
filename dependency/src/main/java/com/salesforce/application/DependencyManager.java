package com.salesforce.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.salesforce.model.DependencyModule;

/**
 * Dependency manager that maintains the installed modules and their dependencies
 * @author njaganathan
 */
public class DependencyManager {

	LinkedHashMap<String, DependencyModule> installedModules = new LinkedHashMap<String, DependencyModule>();
	Map<String, DependencyModule> moduleMap = new HashMap<String, DependencyModule>();

	/**
	 * Process different commands such as
	 * DEPEND
	 * LIST
	 * INSTALL
	 * REMOVE
	 * @param command
	 * @return
	 */
	public String processCommand(String command) {
		if (command == null || command.isEmpty())
			return "";

		command = command.trim();
		if (command.isEmpty())
			return "";

		String[] tokens = command.split("\\s+");
		assert (tokens != null && tokens.length > 0);

		String keyWord = tokens[0];

		switch (keyWord) {
			case "DEPEND": {
				List<String> stringList = new ArrayList<String>();
				for (int i = 2; i < tokens.length; i++)
					stringList.add(tokens[i]);
				return processDepend(tokens[1], stringList);
			}
			case "INSTALL": {
				return processInstall(tokens[1]);
			}
			case "REMOVE": {
				return processRemove(tokens[1]);
			}
			case "LIST": {
				return getList();
			}
			default: {
				return "Unknown Keyword";
			}
		}
	}

	/**
	 * Process getlist command
	 * @return
	 */
	private String getList() {
		StringBuilder sb = new StringBuilder();
		Iterator<String> itr = installedModules.keySet().iterator();
		while (itr.hasNext()) {
			sb.append(itr.next());
			if (itr.hasNext())
				sb.append("\n");
		}
		return sb.toString();
	}

	private String processRemove(String module) {
		if (!installedModules.containsKey(module)) {
			return module + " is not installed";
		}
		DependencyModule installedModule = installedModules.get(module);
		if (installedModule.getDependedBy().size() != 0) {
			return installedModule.getName() + " is still needed";
		}

		List<String> result = new ArrayList<String>();
		installedModule.setStandAloneInstalledModule(false);
		removeModule(installedModule, result);
		String resultStr = StringUtils.join(result, "\n");
		return resultStr;
	}

	/**
	 * Remove modules recursively
	 * @param installedModule
	 * @param result
	 */
	private void removeModule(DependencyModule installedModule, List<String> result) {
		installedModule.setInstalled(false);
		installedModules.remove(installedModule.getName());
		result.add("Removing " + installedModule.getName());
		Set<DependencyModule> dependsOnModules = new HashSet<>(installedModule.getDependsOn());
		for (DependencyModule dOnModule : dependsOnModules) {
			installedModule.removeDependsOn(dOnModule);
			dOnModule.removeDependedBy(installedModule);
		}

		for (DependencyModule dOnModule : dependsOnModules) {
			if (dOnModule.getDependedBy().size() == 0 && !dOnModule.isStandAloneInstalledModule()) {
				removeModule(dOnModule, result);
			}
		}
	}

	/**
	 * Process install command
	 * @param value
	 * @return
	 */
	private String processInstall(String value) {
		DependencyModule installModule = moduleMap.getOrDefault(value, new DependencyModule(value, false));
		if (installModule.isInstalled())
			return installModule.getName() + " is already installed";
		List<String> result = new ArrayList<String>();
		installRecursive(installModule, result);
		installModule.setStandAloneInstalledModule(true);
		installModule.setInstalled(true);
		String resultStr = StringUtils.join(result, "\n");
		return resultStr;
	}

	private void installRecursive(DependencyModule installModule, List<String> result) {
		Set<DependencyModule> dependsOnModules = installModule.getDependsOn();
		for (DependencyModule module : dependsOnModules) {
			if (module.isInstalled() == false)
				installRecursive(module, result);
		}
		installModule.setInstalled(true);
		installedModules.put(installModule.getName(), installModule);
		result.add("Installing " + installModule.getName());
	}

	/**
	 * Process Depend command
	 * @param key
	 * @param values
	 * @return
	 */
	private String processDepend(String key, List<String> values) {
		String result = validateDependency(key, values);
		if (!result.isEmpty())
			return result;
		else
			makeDependencies(key, values);
		return "";
	}

	private void makeDependencies(String key, List<String> values) {
		DependencyModule keyModule = moduleMap.getOrDefault(key, new DependencyModule(key, false));
		for (String value : values) {
			DependencyModule valueModule = moduleMap.getOrDefault(value, new DependencyModule(value, false));
			keyModule.addDependsOn(valueModule);
			valueModule.addDependedBy(keyModule);
			moduleMap.put(value, valueModule);
		}
		moduleMap.put(key, keyModule);
	}

	private String validateDependency(String key, List<String> values) {
		StringBuilder result = new StringBuilder();
		DependencyModule keyModule = moduleMap.getOrDefault(key, new DependencyModule(key, false));
		for (String value : values) {
			DependencyModule valueModule = moduleMap.getOrDefault(value, new DependencyModule(value, false));
			if (valueModule.isDependentOn(keyModule)) {
				result.append(valueModule.getName() + " depends on " + keyModule.getName() + ", ");
			}
		}
		if (result.length() != 0)
			result.append("ignoring command");
		return result.toString();
	}
}
