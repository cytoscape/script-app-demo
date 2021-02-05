package org.cytoscape.scriptapp;

import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import java.io.File;
import java.io.IOException;


public class RunScriptTask extends AbstractTask {
	
	final private String langpath;
	final private String scriptpath;
	
	public RunScriptTask(String langpath, String scriptpath) {
		this.langpath = langpath;
		this.scriptpath = scriptpath;
		
	}
	 
	public void run(TaskMonitor taskMonitor) {
		try{
			System.out.println(scriptpath);
			Runtime.getRuntime().exec(langpath + " " + scriptpath);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}

	