package dev.carv.option;

import io.vavr.control.Option;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionStatus {
    public static void main(String[] args) {
        var o0 = Option.of("foo");
        log.debug("{}", o0.isDefined());
        log.debug("{}", o0.isEmpty());
        log.debug("{}", o0.get());

        var o1 = Option.of(null);
        log.debug("{}", o1.isDefined());
        log.debug("{}", o1.isEmpty());
        log.debug("{}", o1.getOrElse("Other1"));
        log.debug("{}", o1.getOrNull());

        var o2 = Option.some(null);
        log.debug("{}", o2.isDefined());
        log.debug("{}", o2.isEmpty());
        log.debug("{}", o2.getOrElse("Other2"));
        log.debug("{}", o2.get());
    }
}
