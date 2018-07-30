package our.application;

import third.party.library.IQueryBuilder;

public class FilterForHasLinkedContactBuilder implements IQueryBuilder {

	private String table;
	public FilterForHasLinkedContactBuilder(String table) {
        this.table=table;
    }


    public String buildQuery() { //Liskov
    	UniversalQueryBuilder queryBuilder = new UniversalQueryBuilder(table, " AS A INNER JOIN ADDRESS AS B ", "WHERE A.ADDRESSID = B.ID");
        return   queryBuilder.createJoinQuery();
    }

	public void printQuery() {
		System.out.println(buildQuery());
		
	}
}
