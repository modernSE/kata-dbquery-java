package our.application;

public class QueryValidator {

	public static void validateQuery(String query, String tableName) {
	      if (query == null) {
	          throw new IllegalArgumentException("There's no query here!");
	      }

	      if (SystemTableUtil.getSystemTables().contains(tableName.toUpperCase())) {
	          throw new IllegalArgumentException("No system tables allowed");
	      }
	  }
	
}
