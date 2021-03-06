package eventsrc4j.sample.bankaccount;

import eventsrc4j.data;
import java.util.function.Function;

@data
public abstract class AccountState {

  public interface Cases<R> {
    R Unopened();

    R Opened(OpenedAccount openedAccount);

    R Closed();
  }

  AccountState() {
  }

  public abstract <R> R match(Cases<R> cases);

  public final <R> R match(Function<AccountState, R> cases) {
    return cases.apply(this);
  }

  @Override
  public abstract int hashCode();

  @Override
  public abstract boolean equals(Object obj);

  @Override
  public abstract String toString();
}
