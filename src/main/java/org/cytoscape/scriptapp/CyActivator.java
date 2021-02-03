package org.cytoscape.scriptapp;


import org.cytoscape.work.TaskFactory;
import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.session.CyNetworkNaming;

import java.util.Properties;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		RunScriptTaskFactory runScriptTaskFactory = new RunScriptTaskFactory();

		Properties runScriptTaskFactoryProps = new Properties();
		runScriptTaskFactoryProps.setProperty("preferredMenu","Apps.ScriptAppDemo ");
		runScriptTaskFactoryProps.setProperty("title","Run script local");
		registerService(bc,runScriptTaskFactory,TaskFactory.class, runScriptTaskFactoryProps);

		OpenNotebookTaskFactory OpenNotebookTaskFactory = new OpenNotebookTaskFactory();

		Properties openNotebookTaskFactoryProps = new Properties();
		openNotebookTaskFactoryProps.setProperty("preferredMenu","Apps.ScriptAppDemo ");
		openNotebookTaskFactoryProps.setProperty("title","Open interative notebook");
		registerService(bc,OpenNotebookTaskFactory,TaskFactory.class, openNotebookTaskFactoryProps);
}
}
