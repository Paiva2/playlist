package com.root.pattern.adapter.controller.music;

import com.root.pattern.adapter.dto.music.NewMusicDTO;
import com.root.pattern.adapter.dto.music.NewMusicOutputDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/music")
public interface MusicController {
    @PostMapping("/new/category/{categoryId}")
    ResponseEntity<NewMusicOutputDTO> register(
        UUID categoryId,
        Authentication authentication,
        NewMusicDTO newMusicDTO
    );
}