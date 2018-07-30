package our.application;

public class InactiveRecordsQuery extends BaseQuery {

    public InactiveRecordsQuery(String table) {
		super(table);
	}

	@Override
    public String getWherePart() {
        return "WHERE ACTIVE=0 OR ACTIVE IS NULL";
    }

	@Override
	public String getAsPart() {
		return null;
	}
}
