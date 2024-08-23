package com.iemr.ecd.config;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@ContextConfiguration(classes = {WebConfiguration.class})
@ExtendWith(SpringExtension.class)
class WebConfigurationDiffblueTest {
    @Autowired
    private WebConfiguration webConfiguration;

    /**
     * Method under test: {@link WebConfiguration#addCorsMappings(CorsRegistry)}
     */
    @Test
    void testAddCorsMappings() {
        // Arrange
        CorsRegistry registry = mock(CorsRegistry.class);
        when(registry.addMapping(Mockito.<String>any())).thenReturn(new CorsRegistration("Path Pattern"));

        // Act
        webConfiguration.addCorsMappings(registry);

        // Assert
        verify(registry).addMapping(eq("/**"));
    }
}
