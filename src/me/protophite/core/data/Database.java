package me.protophite.core.data;

import me.protophite.core.data.module.UserData;

import java.util.UUID;

public interface Database {
    UserData getUserData(UUID id);
    void saveUser(UUID id);
    void saveAll();
    void newUser(UUID id);
}