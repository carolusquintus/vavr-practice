package dev.carv.option;

import io.vavr.control.Option;
import java.util.function.Predicate;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionFiltering {
    public static void main(String[] args) {

        Predicate<Integer> even = i -> i % 2 == 0;
        Predicate<Integer> odd  = i -> i % 2 != 0;

        var o0 = Option.of(41);
        var even0 = o0.filter(even);
        var odd0 = o0.filter(odd);
        log.debug("{}", even0.isEmpty());
        log.debug("{}", odd0.isDefined());

        var o1 = Optional.of(41);
        var even1 = o1.filter(even);
        var odd1 = o1.filter(odd);
        log.debug("{}", even1.isEmpty());
        log.debug("{}", odd1.isPresent());
        
    }
}
