package org.cytoscape.scriptapp;

import org.cytoscape.work.TaskFactory;
import org.osgi.framework.BundleContext;
import org.cytoscape.application.CyApplicationConfiguration;
import org.cytoscape.service.util.AbstractCyActivator;

import java.io.File;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}

	public void start(BundleContext bc) {

		// EDIT THESE WHILE TESTING
		final String langpath = "/usr/local/bin/python3";
		final String script = "scriptapp.py";

		// Copy script to app-data config dir
		final CyApplicationConfiguration appConf = getService(bc, CyApplicationConfiguration.class);
		final File confDir = appConf.getAppConfigurationDirectoryLocation(this.getClass());
		if (!confDir.exists())
			confDir.mkdirs();
		final String scriptpath = confDir + "/" + script;
		final File toscript = new File(scriptpath);
		
		InputStream fin = null;
		OutputStream fout = null;

		try {
			fin = this.getClass().getClassLoader().getResourceAsStream("/" + script);
			fout = new BufferedOutputStream(new FileOutputStream(toscript));
			byte[] readBytes = new byte[1024];
			int readed = 0;
			while ((readed = fin.read(readBytes)) != -1) {
				fout.write(readBytes, 0, readed);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		// Run script locally
		final RunScriptTaskFactory runScriptTaskFactory = new RunScriptTaskFactory(langpath, scriptpath);

		Properties runScriptTaskFactoryProps = new Properties();
		runScriptTaskFactoryProps.setProperty("preferredMenu", "Apps.ScriptAppDemo ");
		runScriptTaskFactoryProps.setProperty("title", "Run script local");
		registerService(bc, runScriptTaskFactory, TaskFactory.class, runScriptTaskFactoryProps);

		// Open script as interactive notebook
		final OpenNotebookTaskFactory OpenNotebookTaskFactory = new OpenNotebookTaskFactory();

		Properties openNotebookTaskFactoryProps = new Properties();
		openNotebookTaskFactoryProps.setProperty("preferredMenu", "Apps.ScriptAppDemo ");
		openNotebookTaskFactoryProps.setProperty("title", "Open interative notebook");
		registerService(bc, OpenNotebookTaskFactory, TaskFactory.class, openNotebookTaskFactoryProps);

		// Run script as non-interactive notebook
		// TODO
	}
}
