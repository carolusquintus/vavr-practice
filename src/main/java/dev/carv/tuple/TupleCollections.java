package dev.carv.tuple;

import io.vavr.Tuple;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TupleCollections {

    public static void main(String[] args) {
        var list = Arrays.asList(Tuple.of(1, "foo"), Tuple.of(2, "bar"));
        var t0 = Tuple.sequence2(list);

        log.debug("{}", t0);
        t0._1.forEach(i -> log.debug("{}", i));
        t0._2.forEach(s -> log.debug("{}", s));

        var t1 = Tuple.of("Alex", 36);
        var t2 = t1.map(String::toUpperCase, age -> ++age);

        log.debug("{}", t1._1);
        log.debug("{}", t1._2);
        log.debug("{}", t2._1);
        log.debug("{}", t2._2);

        var t3 = Tuple.of("Charles", 32);
        var t4 = t3.map((name, age) -> Tuple.of(name.toUpperCase(), ++age));

        log.debug("{}", t3._1);
        log.debug("{}", t3._2);
        log.debug("{}", t4._1);
        log.debug("{}", t4._2);

        var t5 = Tuple.of("Sergio", 31);
        var t6 = t5.map2(age -> ++age);

        log.debug("{}", t5._1);
        log.debug("{}", t5._2);
        log.debug("{}", t6._1);
        log.debug("{}", t6._2);

    }
}
