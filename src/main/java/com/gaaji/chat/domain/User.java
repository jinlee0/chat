package com.gaaji.chat.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
public class User {
    @Id
    private String id;

    @OneToMany(mappedBy = "user")
    private List<UserRoom> userRooms;

    public void addUserRoom(UserRoom userRoom) {
        this.userRooms.add(userRoom);
    }

    public enum UserStatus {
        ON, OFF;
    }
    private UserStatus status;

    public void online() {
        this.status = UserStatus.ON;
    }

    public void offline() {
        this.status = UserStatus.OFF;
    }

    public boolean isOnline() {
        return this.status == UserStatus.ON;
    }
}
