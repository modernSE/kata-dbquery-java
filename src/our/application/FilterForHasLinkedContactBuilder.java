package our.application;

public class FilterForHasLinkedContactBuilder extends AbstractQueryBuilder {

    public FilterForHasLinkedContactBuilder(String table) {
        super(table);
    }

    @Override
    public String buildBaseQuery() {
        return "SELECT * FROM " + table + " AS A INNER JOIN ADDRESS AS B WHERE A.ADDRESSID = B.ID";
    }
}
