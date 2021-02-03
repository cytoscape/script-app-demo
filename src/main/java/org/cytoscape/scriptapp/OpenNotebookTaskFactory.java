package org.cytoscape.scriptapp;

import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class OpenNotebookTaskFactory extends AbstractTaskFactory {
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new OpenNotebookTask());
	}
}
