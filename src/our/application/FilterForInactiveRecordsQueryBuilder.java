package our.application;

public class FilterForInactiveRecordsQueryBuilder extends AbstractQueryBuilder {


    public FilterForInactiveRecordsQueryBuilder(String table) {
        super(table);
    }

    @Override
    public String buildWherePart() {
        return " WHERE ACTIVE=0 OR ACTIVE IS NULL";
    }
}
