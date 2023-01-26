package com.gaaji.chat.controller;

import com.gaaji.chat.controller.dto.JoonggoChatRoomSaveRequestDto;
import com.gaaji.chat.controller.dto.ChatRoomResponseDto;
import com.gaaji.chat.service.JoonggoChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/joonggo-chat")
public class JoonggoChatController {
    private final JoonggoChatService joonggoChatService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChatRoomResponseDto joonggoChatRoomSave(@RequestHeader(HttpHeaders.AUTHORIZATION) String authId, @RequestBody @Validated JoonggoChatRoomSaveRequestDto dto) {
        return joonggoChatService.createDuoChatRoom(authId, dto);
    }

    @PatchMapping("/{chatRoomId}/members/{memberId}/leave")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void joonggoChatMemberLeave(@RequestHeader(HttpHeaders.AUTHORIZATION) String authId, @PathVariable String chatRoomId, @PathVariable String memberId) {
        joonggoChatService.leaveDuoChatRoom(authId, chatRoomId, memberId);
    }
}
