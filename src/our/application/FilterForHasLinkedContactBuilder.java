package our.application;

public class FilterForHasLinkedContactBuilder extends AbstractQueryBuilder {

    private String table;

    public FilterForHasLinkedContactBuilder(String table) {
        super(table);
        this.table = table;
    }

    @Override
    public String buildWherePart() {
        // not used
        return null;
    }

    @Override
    public String buildQuery() {
        return "SELECT * FROM " + table + " AS A INNER JOIN ADDRESS AS B WHERE A.ADDRESSID = B.ID";
    }
}
