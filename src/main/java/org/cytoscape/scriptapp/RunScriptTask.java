package org.cytoscape.scriptapp;

import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import java.io.*;


public class RunScriptTask extends AbstractTask {
	
	public RunScriptTask() {
		
	}
	 
	public void run(TaskMonitor taskMonitor) {
		try{
			String locallang = "/usr/local/bin/python3";
			String script =  "/Users/alexpico/Desktop/p4c-demo.py";

			Runtime.getRuntime().exec(locallang + " " + script);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

	