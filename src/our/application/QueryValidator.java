package our.application;

public class QueryValidator {
	 
	public boolean isQueryValid(Query query) {
		return !SystemTableUtil.getSystemTables().contains(query.getTable().toUpperCase()); 
	}

}
