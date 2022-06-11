package dev.carv.option;

import io.vavr.control.Option;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionFlatMapping {

    static final String alex = "ALEX";

    public static void main(String[] args) {
        var o0 = Option.of(alex)
                       .map(String::toLowerCase)
                       .flatMap(s -> Option.of(s.length() < 10 ? null : s))
                       .map(s -> "%s size is: %d".formatted(s, s.length()))
                       .getOrElse("Could not proceed");
        log.debug("{}", o0);

        var o1 = Optional.of(alex)
                         .map(String::toLowerCase)
                         .flatMap(s -> Optional.ofNullable(s.length() < 10 ? null : s))
                         .map(s -> "%s size is: %d".formatted(s, s.length()))
                         .orElse("Could not proceed");
        log.debug("{}", o1);
    }
}
