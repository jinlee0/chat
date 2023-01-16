package com.gaaji.chat.controller;

import com.gaaji.chat.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserConnectionController {
    private final RoomService roomService;

    @PatchMapping("/users/{userId}/connection-status/{connectionStatus}")
    @ResponseStatus(HttpStatus.OK)
    public void patchUserConnectionStatus(@PathVariable String userId, @PathVariable String connectionStatus) {
        roomService.patchUserConnectionStatus(userId, connectionStatus);
    }
}