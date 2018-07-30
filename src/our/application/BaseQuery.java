package our.application;

public abstract class BaseQuery implements Query {

	 	private final String table;
	    
	    public BaseQuery(String table) {
			this.table = table;
		}

	    public String getTable() {
			return table;
		}

		public String getBasePart() {
			return "SELECT * FROM " + table;
		}
}
