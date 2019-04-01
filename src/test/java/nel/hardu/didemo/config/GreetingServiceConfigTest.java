package nel.hardu.didemo.config;

import nel.hardu.didemo.services.GreetingService;
import nel.hardu.didemo.services.PrimaryGermanGreetingService;
import nel.hardu.didemo.services.PrimarySpanishGreetingService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GreetingServiceConfigTest
{
    @Nested
    @SpringBootTest(value = "spring.profiles.active=es")
    class TestSpanish
    {
        @Autowired
        GreetingService greetingService;

        @Test
        void testSpanish()
        {
            assertNotNull(greetingService);
            assertThat(greetingService, instanceOf(PrimarySpanishGreetingService.class));
        }
    }

    @Nested
    @SpringBootTest(value = "spring.profiles.active=de")
    class TestGerman
    {
        @Autowired
        GreetingService greetingService;

        @Test
        void testSpanish()
        {
            assertNotNull(greetingService);
            assertThat(greetingService, instanceOf(PrimaryGermanGreetingService.class));
        }
    }
}