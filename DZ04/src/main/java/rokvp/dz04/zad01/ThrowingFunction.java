package rokvp.dz04.zad01;

import java.util.function.Function;

public interface ThrowingFunction<T,R> extends Function<T,R> {

    @Override
    default R apply(T t) {
        try {
            return throwingApply(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static<T,R> Function<T,R> wrap(ThrowingFunction<T, R> f) {
        return f;
    }

    R throwingApply(T t) throws Exception;
}
