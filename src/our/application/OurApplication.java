package our.application;

import third.party.library.QueryBuilder;
import third.party.library.QueryExecutor;

import java.util.Arrays;
import java.util.List;

public class OurApplication {

    public static void main(String[] args) {
        QueryExecutor queryExecutor = new QueryExecutor();

        List<QueryBuilder> queryBuilders = Arrays.asList(
                new FilterForActiveRecordsQueryBuilder("CONTACTS"),
                new FilterForInactiveRecordsQueryBuilder("CONTACTS"),
                new FilterForHasLinkedContactBuilder("CONTACTS"));

        queryBuilders.stream()
                .map(queryExecutor::executeQuery)
                .flatMap(rows -> rows.stream())
                .forEach(System.out::println);
    }
}
