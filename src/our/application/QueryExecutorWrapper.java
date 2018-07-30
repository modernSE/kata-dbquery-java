package our.application;

import java.util.List;

import third.party.library.QueryExecutor;

public class QueryExecutorWrapper {
	
	private final QueryExecutor queryExecutor = new QueryExecutor();
	
	public void execute(Query query) {
		QueryBuilderWrapper queryBuilder = new QueryBuilderWrapper(query);
		List<List<String>> executeQuery = queryExecutor.executeQuery(queryBuilder);
		
		executeQuery.stream()
		.flatMap(rows -> rows.stream())
        .forEach(System.out::println);
	}

}
