package our.application;

public class ActiveRecordsQuery extends BaseQuery {

	public ActiveRecordsQuery(String table) {
		super(table);
	}

	@Override
	public String getWherePart() {
		return "WHERE ACTIVE=1";
	}

	@Override
	public String getAsPart() {
		return null;
	}
}
