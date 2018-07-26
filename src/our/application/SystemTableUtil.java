package our.application;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SystemTableUtil {
    public static final Set<String> getSystemTables() {
        return Collections.singleton("SSHKEYS");
    }
}
