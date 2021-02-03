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
		runScriptTaskFactoryProps.setProperty("title","Run Script-App");
		registerService(bc,runScriptTaskFactory,TaskFactory.class, runScriptTaskFactoryProps);
	}
}
