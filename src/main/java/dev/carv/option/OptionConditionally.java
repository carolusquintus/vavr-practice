package dev.carv.option;

import io.vavr.control.Option;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionConditionally {

    public static void main(String[] args) {
        var i = 42;
        var o0 = Option.when(i % 2 == 0, "foo");
        log.debug("{}", o0);
        log.debug("{}", o0.isDefined());

        var o1 = Option.when(i > 0, () -> "foo");
        log.debug("{}", o1);
        log.debug("{}", o1.isDefined());

        var o2 = Option.when(i < 0, "bar");
        log.debug("{}", o2);
        log.debug("{}", o2.isEmpty());
    }
}
