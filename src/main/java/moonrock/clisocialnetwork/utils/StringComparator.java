package moonrock.clisocialnetwork.utils;

import lombok.AllArgsConstructor;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@AllArgsConstructor
public class StringComparator {
    private final String s1;
    private final String s2;

    public String getFirst() {
        if (s1.compareTo(s2) < 0)
            return s1;
        else
            return s2;
    }

    public String getSecond() {
        if (s1.compareTo(s2) < 0)
            return s2;
        else
            return s1;
    }
}
