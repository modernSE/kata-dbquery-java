package third.party.library;

import java.util.Collections;
import java.util.List;

public class QueryExecutor {

    public List<List<String>> executeQuery(QueryBuilder builder) {
        String query = builder.buildQuery();

        // to the database, Robin!
        return Collections.singletonList(Collections.singletonList("Query: " + query));
    }
}
