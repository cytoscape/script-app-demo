package org.cytoscape.scriptapp;

import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import java.io.*;


public class OpenNotebookTask extends AbstractTask {
	
	public OpenNotebookTask() {
		
	}
	 
	public void run(TaskMonitor taskMonitor) {
		try{
			String opencmd = "open";
			String notebook =  "https://colab.research.google.com/drive/1Gzh115cmdLGdgkEJ5MVol7AlIcbrzYlC#scrollTo=rudBsR8_Kabr";

			Runtime.getRuntime().exec(opencmd + " " + notebook);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

	