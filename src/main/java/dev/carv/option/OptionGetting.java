package dev.carv.option;

import io.vavr.control.Option;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public class OptionGetting {

    public static void main(String[] args) {
        var age0 = Option.of(42).getOrElse(0);
        var age1 = Option.of(null).getOrElse(0);
        log.debug("{}", age0);
        log.debug("{}", age1);

        var alex = Option.of(null);
        var eva = Option.of("Eva");
        var cute = alex.orElse(eva);
        log.debug("{}", alex);
        log.debug("{}", eva);
        log.debug("{}", cute);


        Function<Integer, String> goodLuck = "Feeling lucky: %d"::formatted;
        Supplier<String> badLuck = () -> "Bad luck";

        var r0 = new Random();
        var o0 = Option.of(r0.nextBoolean() ? r0.nextInt() : null);
        var str0 = o0.fold(badLuck, goodLuck);
        log.debug("{}", str0);

        var r1 = new Random();
        var o1 = Optional.ofNullable(r1.nextBoolean() ? r1.nextInt() : null);
        var str1 = o1.map(goodLuck).orElseGet(badLuck);
        log.debug("{}", str1);

    }
}
