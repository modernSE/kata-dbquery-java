package our.application;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import third.party.library.QueryBuilder;

public abstract class AbstractQueryBuilder implements QueryBuilder {

    protected final String table;

    public AbstractQueryBuilder(String table) {
        this.table = table;
    }

    public final String buildQuery() {
    	String baseQuery = buildBaseQuery();
        String where = buildWherePart();    
        String query = baseQuery + ((where != null && !where.isEmpty()) ? " " + where : "");
        validateQuery(query);        
        return query;
    }

    protected String buildBaseQuery() {
        return "SELECT * FROM " + table;
    }

    protected String buildWherePart() {
    	return null;
    }

    @Override
    public void printQuery() {
        System.out.println(buildQuery());
    }

    private void validateQuery(String query) {
        if (query == null) {
            throw new RuntimeException("There's no query here!");
        }
        
        Set<String> tableCallsToCheck = getTableCalls(query);

        if(tableCallsToCheck.stream().filter(t -> SystemTableUtil.getSystemTables().contains(t)).findAny().isPresent()) {
            throw new RuntimeException("No system tables allowed");
        }
    }
    
    private Set<String> getTableCalls(final String query) {
    	
    	Set<String> tableCalls = getFromTableAppereans(query);
    	tableCalls.addAll(getJoinTableAppereans(query));
    	
    	return tableCalls;
    }

    private Collection<? extends String> getJoinTableAppereans(final String query) {
		//TODO extract JOIN values from query
		return Collections.emptySet();
	}

	private Set<String> getFromTableAppereans(final String query) {		
		//TODO extract FROM values from query
		if(query.contains("SSHKEYS")) {
			return Collections.singleton("SSHKEYS");			
		} else {
			return Collections.emptySet();
		}
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
