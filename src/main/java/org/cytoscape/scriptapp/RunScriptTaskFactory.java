package org.cytoscape.scriptapp;

import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class RunScriptTaskFactory extends AbstractTaskFactory {
	
	final private String langpath;
	final private String scriptpath;
	
	public RunScriptTaskFactory(String langpath, String scriptpath) {
		this.langpath = langpath;
		this.scriptpath = scriptpath;
	}

	public TaskIterator createTaskIterator(){
		return new TaskIterator(new RunScriptTask(langpath, scriptpath));
	}
}
