package com.root.pattern.application.factory.user;

import com.root.pattern.adapter.repository.UserDataProviderImpl;
import com.root.pattern.domain.strategy.concrete.EmailValidatorRegexStrategy;
import com.root.pattern.domain.strategy.context.MailValidator;
import com.root.pattern.domain.usecase.user.RegisterUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
public class RegisterUserFactory {
    private final UserDataProviderImpl userDataProvider;
    private final PasswordEncoder passwordEncoder;

    @Bean("RegisterUserUseCase")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RegisterUserUseCase create() {
        return RegisterUserUseCase.builder()
                .userDataProvider(userDataProvider)
                .passwordEncoder(passwordEncoder)
                .mailValidator(new MailValidator(new EmailValidatorRegexStrategy()))
                .build();
    }
}
