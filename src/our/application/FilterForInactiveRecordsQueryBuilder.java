package our.application;

import third.party.library.QueryBuilder;

public class FilterForInactiveRecordsQueryBuilder implements QueryBuilder {
private String table;

    public FilterForInactiveRecordsQueryBuilder(String table) {
        this.table=table;
    }

    public String buildQuery() {
    	UniversalQueryBuilder queryBuilder = new UniversalQueryBuilder(table, "", " WHERE ACTIVE=0 OR ACTIVE IS NULL");
        return queryBuilder.createWhereQuery();
    }

	public void printQuery() {
		  System.out.println(buildQuery());
	}
}
