package org.cytoscape.scriptapp;

import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class RunScriptTaskFactory extends AbstractTaskFactory {
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new RunScriptTask());
	}
}
