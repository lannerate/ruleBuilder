package com.flagleader.repository.f;

import com.flagleader.repository.tree.GroupInfo;
import com.flagleader.repository.tree.PackageInfo;
import java.util.List;

public abstract class q
  implements b
{
  public static q a(c paramc)
  {
    if ((paramc instanceof h))
      return new g((h)paramc);
    return new m();
  }

  public abstract Object b(String paramString);

  public abstract List a();

  public abstract boolean a(String paramString1, String paramString2);

  public abstract boolean d();

  public abstract boolean e();

  public abstract boolean f();

  public abstract boolean g();

  public abstract List c(String paramString);

  public abstract boolean c();

  public abstract PackageInfo a(String paramString1, String paramString2, String paramString3);

  public abstract PackageInfo a(String paramString1, String paramString2, String paramString3, String paramString4);

  public abstract boolean d(String paramString1, String paramString2);

  public abstract p a(String paramString);

  public abstract GroupInfo c(String paramString1, String paramString2);

  public abstract void b();

  public abstract boolean b(String paramString1, String paramString2);

  public abstract String f(String paramString1, String paramString2);

  public abstract String e(String paramString1, String paramString2);

  public abstract boolean e(String paramString);

  public abstract boolean d(String paramString);

  public abstract boolean h();

  public abstract d i();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.f.q
 * JD-Core Version:    0.6.0
 */