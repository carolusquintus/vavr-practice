package dev.carv.option;

import io.vavr.control.Option;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionCreation {

    public static void main(String[] args) {
        var o0 = Option.of("foo");
        var o1 = Option.of("foo");
        log.debug("{}", o0.equals(o1));

        var o3 = Optional.ofNullable(42);
        var o4 = Option.of(42);
        var o5 = Option.ofOptional(Optional.ofNullable(42));
        log.debug("{}", o3);
        log.debug("{}", o4);
        log.debug("{}", o5);
    }
}
