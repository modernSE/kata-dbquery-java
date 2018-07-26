Summary:
We are programming a small library to access our Database and query it for contact data.
It has come to our attention, that malicious code can be introduced that will query our very secret
SSHKEYS table. We are, however, a very secure bunch of coders that won't let that happen. We have
decided to introduce the concept of "SYSTEM TABLES", i.e. the tables that must not be queried by
anyone outside the system context. There's a utility class, that returns a Set of all the system
tables (currently only SSHKEYS).

Task:

Introduce a check that will ensure that no table contained in system tables is queried. There's an
abstract parent class for all our queries. Should be no problem, right?