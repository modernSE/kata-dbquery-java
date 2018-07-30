package our.application;

import third.party.library.QueryBuilder;

public class QueryBuilderWrapper implements QueryBuilder {

	private Query query;
   
    public QueryBuilderWrapper(Query query) {
        this.query = query;
    }

    @Override
    public String buildQuery() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(query.getBasePart()+" ");
    	sb.append(query.getAsPart() != null ? query.getAsPart()+" " : "");
    	sb.append(query.getWherePart() != null ? query.getWherePart()+" " : "");
        return sb.toString();
    }
   

    @Override
    public void printQuery() {
        System.out.println(buildQuery());
    }

    @Override
    public String wrapInsidePerformanceLogging() {
        return "SET PERFORMANCE LOGGING ENABLED; \n" + buildQuery() + "\nSET PERFORMANCE LOGGING DISABLED;";
    }

    @Override
    public boolean isAppendUserContext() {
        return true;
    }

    @Override
    public boolean isForceUnicode() {
        return true;
    }
}
