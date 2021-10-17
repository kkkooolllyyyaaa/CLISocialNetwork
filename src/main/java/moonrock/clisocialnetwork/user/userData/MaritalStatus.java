package moonrock.clisocialnetwork.user.userData;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@AllArgsConstructor
public enum MaritalStatus {
    ENGAGED("Engaged"),
    IN_ACTIVE_SEARCH("In active search")
    ;
    @Getter
    private final String status;
}
