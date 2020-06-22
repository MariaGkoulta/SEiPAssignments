package codeanalyzer;


/**
* Represents a metric type, i.e loc, noc, nom
* @author Maria Gkoulta
* @author marygkoulta@gmail.com
*/
public interface Metric {
	
	/**
	 * Returns the pattern which has to be matched for the
	 * calculation of the specific metric
	 * @return the pattern that has to be matched
	*/
	public String getPattern();
	
	/**
	 * Evaluates whether a line is valid or invalid and has 
	 * to be taken into account for the specific metric
	 * @param line that has to be evaluated
	 * @return true, if the line must be added or substracted
	*/
	public Boolean evaluateLine(String line);
	public String getName();
	
	
	/**
	 * Evaluates whether the matches found have to be added to 
	 * the source code or substracted from it. That depends on
	 * whether the pattern defines what is counted as a metric or
	 * what parts of the code are not included in this metric and
	 * thus, have to be substracted from the total
	 * @param line that has to be evaluated
	 * @return true if the above condition is true, false otherwise
	*/
	public Boolean substractFromTotal();
}

class LocMetric implements Metric {
	
	@Override
	public String getPattern() {
		String stringPattern = "((//.*)|(/\\*.*)|(\\*+.*))";
		return stringPattern;
	}
	
	@Override
	public Boolean evaluateLine(String line) {
		return (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""));
	}
	
	@Override
	public String getName() {
		return "loc";
	}
	
	@Override
	public Boolean substractFromTotal() {
		return true;
	}
}

class NomMetric implements Metric {
	
	@Override
	public String getPattern() {
		String stringPattern = ".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*";
		return stringPattern;
	}
	@Override
	public Boolean evaluateLine(String line) {
		return (((line.contains("public") || line.contains("private") || line.contains("protected"))
				|| line.contains("void") || line.contains("int") || line.contains("String"))
			&& line.contains("(") && line.contains(")") && line.contains("{") );
	}
	
	@Override
	public String getName() {
		return "nom";
	}

	@Override
	public Boolean substractFromTotal() {
		return false;
	}
}

class NocMetric implements Metric {
	
	@Override
	public String getPattern() {
		String stringPattern = ".*\\s*class\\s+.*";
		return stringPattern;
	}
	
	@Override
	public Boolean evaluateLine(String line) {
		return ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{"));
	}

	@Override
	public String getName() {
		return "noc";
	}
	
	@Override
	public Boolean substractFromTotal() {
		return false;
	}
}