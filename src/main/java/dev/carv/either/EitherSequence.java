package dev.carv.either;

import io.vavr.control.Either;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EitherSequence {

    public static void main(String[] args) {

        var e1 = Either.sequence(List.of(
            Either.left("foo"), Either.right(1), Either.left("bar")
        ));
        log.debug("left: {}", e1.isLeft());
        log.debug("left: {}", e1.getLeft());

        var e2 = Either.sequence(List.of(
            Either.right(1), Either.right(2)
        ));
        log.debug("right: {}", e2.isRight());
        log.debug("right: {}", e2.get());
    }
}
