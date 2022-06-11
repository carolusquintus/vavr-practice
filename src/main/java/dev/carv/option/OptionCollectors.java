package dev.carv.option;

import io.vavr.control.Option;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionCollectors {

    public static void main(String[] args) {

        var l1 = Option.of("foo")
            .collect(Collectors.toList());
        log.debug("{}", l1);

        var l2 = Optional.of("foo").stream()
            .collect(Collectors.toList());
        log.debug("{}", l2);

        var l3 = Option.of("foo")
            .collect(Collectors.summarizingInt(String::length));
        log.debug("{}", l3);

        var l4 = Optional.of("foo").stream()
            .collect(Collectors.summarizingInt(String::length));
        log.debug("{}", l4);
    }
}
