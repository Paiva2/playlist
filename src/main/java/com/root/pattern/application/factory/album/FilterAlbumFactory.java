package com.root.pattern.application.factory.album;

import com.root.pattern.domain.interfaces.repository.AlbumDataProvider;
import com.root.pattern.domain.usecase.album.FilterAlbumUsecase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@AllArgsConstructor
public class FilterAlbumFactory {
    private final AlbumDataProvider albumDataProvider;

    @Bean("FilterAlbumUsecase")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public FilterAlbumUsecase create() {
        return FilterAlbumUsecase.builder()
            .albumDataProvider(this.albumDataProvider)
            .build();
    }
}
