package our.application;

import third.party.library.QueryBuilder;

public abstract class AbstractQueryBuilder implements QueryBuilder {

    private final String table;

    public AbstractQueryBuilder(String table) {
        this.table = table;
    }

    @Override
    public String buildQuery() {
        String baseQuery = buildBaseQuery();
        String where = buildWherePart();
        return baseQuery + " " + where;
    }

    private String buildBaseQuery() {
        return "SELECT * FROM " + table;
    }

    public abstract String buildWherePart();

    @Override
    public void printQuery() {
        System.out.println(buildQuery());
    }

    private void validateQuery(String query) {
        if (query == null) {
            throw new RuntimeException("There's no query here!");
        }

        if (SystemTableUtil.getSystemTables().contains(table.toUpperCase())) {
            throw new RuntimeException("No system tables allowed");
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
