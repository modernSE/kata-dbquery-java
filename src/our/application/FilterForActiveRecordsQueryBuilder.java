package our.application;

public class FilterForActiveRecordsQueryBuilder extends AbstractQueryBuilder {


    public FilterForActiveRecordsQueryBuilder(String table) {
        super(table);
    }

    @Override
    public String buildWherePart() {
        return " WHERE ACTIVE=1";
    }
}
