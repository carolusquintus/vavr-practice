package dev.carv.option;

import io.vavr.control.Option;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionTransforming {

    public static void main(String[] args) {

        var length0 = Option.of("foo")
                            .transform(s -> s.getOrElse("").length());
        log.debug("{}", length0);

        var length1 = Option.of("foo")
                            .map(String::length)
                            .getOrElse(0);
        log.debug("{}", length1);

        var length2 = Optional.of("foo")
                              .map(String::length)
                              .orElse(0);
        log.debug("{}", length2);
    }
}
