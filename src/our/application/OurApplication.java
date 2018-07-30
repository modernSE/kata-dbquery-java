package our.application;

import java.util.ArrayList;
import java.util.List;

public class OurApplication {
	
    public static void main(String[] args) {
    	QueryValidator queryValidator = new QueryValidator();
        QueryExecutorWrapper queryExecutor = new QueryExecutorWrapper();

        List<Query> queries = new ArrayList<>();
        queries.add(new ActiveRecordsQuery("CONTACTS"));
        queries.add(new InactiveRecordsQuery("CONTACTS"));
        queries.add(new HasLinkedContactQuery());
        
        queries.stream().filter(queryValidator::isQueryValid).forEach(q -> queryExecutor.execute(q));
    }
}
