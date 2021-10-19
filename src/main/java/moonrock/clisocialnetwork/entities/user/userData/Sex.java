package moonrock.clisocialnetwork.entities.user.userData;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@AllArgsConstructor
public enum Sex {
    FEMALE("Female"),
    MALE("Male"),
    UNDEFINED("Undefined");

    @Getter
    private final String sex;
}
