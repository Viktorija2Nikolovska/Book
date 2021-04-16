package finki.ukim.mk.books.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_LIBRARIAN, ROLE_USER;

    @Override
    public String getAuthority() {

        return name();
    }
}
