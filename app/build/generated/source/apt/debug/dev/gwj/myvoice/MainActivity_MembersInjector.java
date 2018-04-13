// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package dev.gwj.myvoice;

import dagger.MembersInjector;
import dev.gwj.myvoice.bean.Perseon;
import javax.inject.Provider;

public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<Perseon> personProvider;

  public MainActivity_MembersInjector(Provider<Perseon> personProvider) {
    assert personProvider != null;
    this.personProvider = personProvider;
  }

  public static MembersInjector<MainActivity> create(Provider<Perseon> personProvider) {
    return new MainActivity_MembersInjector(personProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.person = personProvider.get();
  }

  public static void injectPerson(MainActivity instance, Provider<Perseon> personProvider) {
    instance.person = personProvider.get();
  }
}