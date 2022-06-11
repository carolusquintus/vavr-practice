package dev.carv.either;

import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EitherCreation {

    public static void main(String[] args) {

        var e1 = Either.left("foo");
        var e2 = Either.right("bar");

        log.debug("{}", e1);
        log.debug("{}", e2);
    }
}
