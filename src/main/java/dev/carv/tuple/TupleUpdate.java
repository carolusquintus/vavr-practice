package dev.carv.tuple;

import io.vavr.Tuple;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TupleUpdate {

    public static void main(String[] args) {
        var t0 = Tuple.of("Lando", 50);
        var newT0 = t0.update2(50);
        log.debug("{}", newT0._1);
        log.debug("{}", newT0._2);

        var t1 = Tuple.of("Esteban", 28);
        var hello = t1.apply("My name is %s and I'm %d years old"::formatted);
        log.debug(hello);

        var t2 = Tuple.of("Valttery", 32, "Finland");
        log.debug("{}", t2.arity()); // to get Tuple's size
    }
}
