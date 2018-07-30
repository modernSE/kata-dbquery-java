package our.application;

import third.party.library.IQueryBuilder;

public class FilterForInactiveRecordsQueryBuilder implements IQueryBuilder {
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
