package codeanalyzer;

public interface Metric {
	
	public String getPattern();
	public Boolean evaluateLine(String line);
	public String getName();
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