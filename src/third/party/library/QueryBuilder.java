package third.party.library;

public interface QueryBuilder {
    String buildQuery();
    void printQuery();
    String wrapInsidePerformanceLogging();
    boolean isAppendUserContext();
    boolean isForceUnicode();
}
