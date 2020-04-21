package cn.fancy.plugin.loombok;

public class User {
    private Integer id;
    private String name;
    private String address;

    private User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    private User(User origin) {
        this.id = origin.id;
        this.name = origin.name;
        this.address = origin.address;
    }

    public static class Builder {
        private User target;

        public Builder() {
            this.target = new User();
        }

        public Builder id(Integer id) {
            target.id = id;
            return this;
        }

        public Builder name(String name) {
            target.name = name;
            return this;
        }

        public Builder address(String address) {
            target.address = address;
            return this;
        }

        public User build() {
            return new User(target);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "target=" + target +
                    '}';
        }
    }
}