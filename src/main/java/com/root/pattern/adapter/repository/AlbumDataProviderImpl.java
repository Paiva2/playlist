package com.root.pattern.adapter.repository;

import com.root.pattern.domain.entity.Album;
import com.root.pattern.domain.interfaces.repository.AlbumDataProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Component
public class AlbumDataProviderImpl implements AlbumDataProvider {
    private final AlbumRepository albumRepository;

    @Override
    public Optional<Album> findById(UUID id) {
        return this.albumRepository.findById(id);
    }

    @Override
    public Album register(Album album) {
        return this.albumRepository.save(album);
    }

    @Override
    public Optional<Album> findByAlbumNameAndMusicianId(String albumName, Long musicianId) {
        return this.albumRepository.findByAlbumNameAndMusicianId(albumName, musicianId);
    }
}
