package our.application;

public class HasLinkedContactQuery extends BaseQuery {

    public HasLinkedContactQuery() {
        super("CONTACTS");
    }

    @Override
    public String getWherePart() {
        return "WHERE A.ADDRESSID = B.ID";
    }

    @Override
    public String getAsPart() {
        return "AS A INNER JOIN ADDRESS AS B";
    }
}
