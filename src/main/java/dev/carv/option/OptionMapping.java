package dev.carv.option;

import io.vavr.control.Option;
import java.util.function.Function;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class OptionMapping {

    static final String alex  = "alex";
    static final String chela = null;
    static final String xela  = "XELA";
    static final String notProceed = "Could not proceed";
    static final String enjoyingString = " is enjoying vavr";

    public static void main(String[] args) {

        Function<String, String> enjoying   = s -> s.concat(enjoyingString);
        Function<String, String> reverse    = s -> new StringBuilder(s).reverse().toString();
        Function<String, String> capitalize = s -> Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();

        var o0 = Option.of(alex)
                       .map(String::toUpperCase)
                       .getOrElse(notProceed);
        log.debug("{}", o0);

        var o1 = Optional.ofNullable(alex)
                         .map(String::toUpperCase)
                         .orElse(notProceed);
        log.debug("{}", o1);



        var o2 = Option.of(chela)
                       .map(StringUtils::reverse)
                       .map(StringUtils::lowerCase)
                       .map(StringUtils::capitalize)
                       .map(enjoying)
                       .getOrElse(notProceed);
        log.debug("{}", o2);

        var o3 = Option.of(xela)
                       .map(StringUtils::reverse)
                       .map(StringUtils::lowerCase)
                       .map(StringUtils::capitalize)
                       .map(enjoying)
                       .getOrElse(notProceed);
        log.debug("{}", o3);


        var o4 = Optional.ofNullable(chela)
                         .map(reverse)
                         .map(String::toLowerCase)
                         .map(capitalize)
                         .map(enjoying)
                         .orElse(notProceed);
        log.debug("{}", o4);

        var o5 = Optional.ofNullable(xela)
                         .map(reverse)
                         .map(String::toLowerCase)
                         .map(capitalize)
                         .map(enjoying)
                         .orElse(notProceed);
        log.debug("{}", o5);



        var o6 = Option.of(xela);
        log.debug("{}", optionXELA(o6));

        var o7 = Optional.of(xela);
        log.debug("{}", optionalXELA(o7));

    }

    private static String optionXELA(Option<String> o) {
        if (o.isDefined())
            return StringUtils.capitalize(
                StringUtils.lowerCase(
                    StringUtils.reverse(o.get())
                )
            ).concat(enjoyingString);
        return null;
    }

    private static String optionalXELA(Optional<String> o) {
        if (o.isPresent()) {
            var reversed = new StringBuilder(o.get()).reverse().toString();
            var lowered = reversed.toLowerCase();
            var capitalized = Character.toUpperCase(lowered.charAt(0)) + lowered.substring(1);
            return capitalized.concat(enjoyingString);
        }
        return null;
    }

}
