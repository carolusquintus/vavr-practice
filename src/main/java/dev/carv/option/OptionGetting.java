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
        var o1 = Option.of(r1.nextBoolean() ? r1.nextInt() : null);
        var str1 = o1.map(goodLuck).getOrElse(badLuck);
        log.debug("{}", str1);

        var r2 = new Random();
        var o2 = Optional.ofNullable(r2.nextBoolean() ? r2.nextInt() : null);
        var str2 = o2.map(goodLuck).orElseGet(badLuck);
        log.debug("{}", str2);


        var r3 = new Random();
        var o3 = Option.of(r3.nextBoolean() ? r3.nextInt() : null);
        var str3 =
            o3.fold(badLuck, Function.identity());
        log.debug("{}", str3);

        var r4 = new Random();
        var o4 = Optional.ofNullable(r4.nextBoolean() ? r4.nextInt() : null);
        var int4 = o4.orElse(0);
        log.debug("{}", int4);



        Supplier<RuntimeException> noLosers = () -> new RuntimeException("No losers in this Casino");

        var r5 = new Random();
        var o5 = Option.of(r5.nextBoolean() ? r5.nextInt() : null);
        var int5 = o5.getOrElseThrow(noLosers);
        log.debug("{}", int5);

        var r6 = new Random();
        var o6 = Optional.ofNullable(r6.nextBoolean() ? r6.nextInt() : null);
        var int6 = o6.orElseThrow(noLosers);
        log.debug("{}", int6);

    }
}
