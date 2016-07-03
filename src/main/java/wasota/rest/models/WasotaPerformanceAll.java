package wasota.rest.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import wasota.core.graph.WasotaGraphInterface;

public class WasotaPerformanceAll {

	
	public WasotaPerformanceAll(String context, WasotaGraphInterface wasotaGraph) {
		performanceByContext(context, wasotaGraph);
	}

	public List<String> performanceList = new ArrayList<String>();

	public void performanceByContext(String context, WasotaGraphInterface wasotaGraph) {

		List<String> appList = wasotaGraph.queries().getAlgorithmList(context);

		// get list of experiment
		List<String> expList = wasotaGraph.queries().getExperimentList(appList);

		// get list of experiment config
		List<String> expListConfig = wasotaGraph.queries().getExperimentConfigList(expList);

		// get list of execution
		List<String> executionList = wasotaGraph.queries().getExecutionList(expListConfig);

		// get list measure classification
		List<String> measureClassification = wasotaGraph.queries().getMeasureList(executionList);

		// get all performance types
		performanceList = wasotaGraph.queries().getAllPerformanceTypes(measureClassification); 

	}

}
