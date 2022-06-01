package dev.carv.option;

import io.vavr.control.Option;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionCollections {
    public static void main(String[] args) {
        var o0 = Option.sequence(List.of(Option.of(1), Option.of(2)));
        log.debug("{}", o0.isDefined());
        log.debug("{}", o0.get());

        var o1 = Option.sequence(List.of(Option.of(1), Option.none(), Option.of(2)));
        log.debug("{}", o1.isDefined());

        var o2 = Option.traverse(List.of(1, 2, 3), n -> Option.of(n > 0 ? n : null));
        log.debug("{}", o2.isDefined());
        log.debug("{}", o2.get());

        var o3 = Option.traverse(List.of(1, 2, -1, 3, -4), n -> Option.of(n > 0 ? n : null));
        log.debug("{}", o3.isDefined());
    }
}
