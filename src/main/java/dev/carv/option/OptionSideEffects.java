package dev.carv.option;

import io.vavr.control.Option;

import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionSideEffects {

    public static void main(String[] args) {

        var r = new Random();

        Consumer<Integer> lucky = i -> log.debug("Felling lucky {}", i);
        Runnable badLuck        = () -> log.debug("{}", "Bad luck");

        Option.of(r.nextBoolean() ? r.nextInt() : null)
            .peek(lucky)
            .onEmpty(badLuck);

        Optional.ofNullable(r.nextBoolean() ? r.nextInt() : null)
            .ifPresentOrElse(
                lucky,
                badLuck);

    }
}
