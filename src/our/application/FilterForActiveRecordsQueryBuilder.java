package our.application;

import third.party.library.IQueryBuilder;

public class FilterForActiveRecordsQueryBuilder implements  IQueryBuilder {

private String table;

    public FilterForActiveRecordsQueryBuilder(String table) {
       this.table=table;
    }

    public String buildQuery() {
    	UniversalQueryBuilder queryBuilder = new UniversalQueryBuilder(table, "", " WHERE ACTIVE=1");
        
        return  queryBuilder.createWhereQuery();
    }
    
	public void printQuery() {
		System.out.println(buildQuery());
	}
}
