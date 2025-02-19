package domain;

import java.util.Objects;

public class Player {

    private static final int MAXIMUM_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private  void validateNameLength(String name) {
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 사람 이름은 최대 5글자 입니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
