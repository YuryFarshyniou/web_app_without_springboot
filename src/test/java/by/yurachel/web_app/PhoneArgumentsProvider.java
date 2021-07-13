package by.yurachel.web_app;

import by.yurachel.web_app.model.phone.impl.Phone;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class PhoneArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        new Phone(1, "Xiaomi Mi 11 lite", 500, "Snapdragon 732G"),
                        new Phone(2, "Xiaomi Mi 11 ultra", 1200, "Snapdragon 888"),
                        new Phone(3, "Iphone 12 mini", 1000, "Apple A14 Bionic"),
                        new Phone(4, "Samsung Galaxy S20", 900, "Exynos 990"),
                        new Phone(5, "Poco X3 Pro", 350, "Snapdragon 860")))
        );
    }
}
