package com.root.pattern.adapter.controller.playlist;

import com.root.pattern.adapter.dto.playlist.ListOwnPlaylistsOutputdTO;
import com.root.pattern.adapter.dto.playlist.NewPlaylistInputDTO;
import com.root.pattern.adapter.dto.playlist.NewPlaylistOutputDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/playlist")
public interface PlaylistController {
    @PostMapping("/new")
    ResponseEntity<NewPlaylistOutputDTO> create(
        Authentication authentication,
        NewPlaylistInputDTO dto
    );

    @GetMapping("/own/list")
    ResponseEntity<ListOwnPlaylistsOutputdTO> listOwn(Authentication authentication, Integer page, Integer perPage, String name);
}