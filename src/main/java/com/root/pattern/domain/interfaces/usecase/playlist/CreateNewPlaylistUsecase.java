package com.root.pattern.domain.interfaces.usecase.playlist;

import com.root.pattern.adapter.dto.playlist.NewPlaylistOutputDTO;
import com.root.pattern.domain.entity.Playlist;
import com.root.pattern.domain.entity.User;

public interface CreateNewPlaylistUsecase {
    NewPlaylistOutputDTO exec(Long userId, Playlist playlist);

    void inputsValidation(Long userId, Playlist playlist);

    User checkIfUserExists(Long userId);

    void checkIfUserIsDisabled(User user);

    void checkIfUserHasSamePlaylist(String playlistName, Long userId);

    Integer lastOrderedPlaylist(Long userId);

    Playlist persistNewPlaylist(Playlist playlist);

    NewPlaylistOutputDTO mountOutput(Playlist playlist);
}