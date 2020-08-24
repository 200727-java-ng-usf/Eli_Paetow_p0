package com.revature.models;

public enum Role {

    // values declared within enums are constants and are comma separated
    ADMIN("Admin"),
    MANAGER("Manager"),
    PREMIUM_MEMBER("Premium Member"),
    BASIC_MEMBER("Basic Member"),
    LOCKED("Locked");

    private String roleName;

    // enum constructors are implicitly private
    Role(String name) {
        this.roleName = name;
    }

    public static Role getByName(String name) {

        for (Role role : Role.values()) {
            if (role.roleName.equals(name)) {
                return role;
            }
        }

        return LOCKED;

    }

    @Override
    public String toString() {
        return roleName;
    }

}
