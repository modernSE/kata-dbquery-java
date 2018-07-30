package our.application;

public class UniversalQueryBuilder {
	
	private static String baseQuery ="SELECT * FROM ";
	private final String tableName;
	private final String joinClause;
	private final String whereClause;

	public UniversalQueryBuilder(String tableName, String joinClause, String whereClause) {
		super();
		this.tableName = tableName;
		this.joinClause = joinClause;
		this.whereClause = whereClause;
	}	
	
	private String createSelectStatement() {
		return baseQuery+tableName+" ";
	}
	
	public String createJoinQuery() throws IllegalArgumentException{
		String query=createSelectStatement()+joinClause+whereClause;
		QueryValidator.validateQuery(query, tableName);
		return query;
	}
	
	public String createWhereQuery() throws IllegalArgumentException{
		String query = createSelectStatement()+whereClause;
		QueryValidator.validateQuery(query, tableName);
		return query;
	}
	
}
