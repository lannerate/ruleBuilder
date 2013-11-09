package com.flagleader.repository.lang;

import java.util.Iterator;
import java.util.List;

public abstract interface d
{
  public abstract Iterator a();

  public abstract Iterator a(g paramg);

  public abstract List a(TypeMethod paramTypeMethod, List paramList);

  public abstract String b(TypeMethod paramTypeMethod, List paramList);

  public abstract String c(TypeMethod paramTypeMethod, List paramList);

  public abstract List a(GlobalMethod paramGlobalMethod);

  public abstract String b(GlobalMethod paramGlobalMethod);

  public abstract String c(GlobalMethod paramGlobalMethod);

  public abstract MethodInfos b();

  public abstract void c();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.d
 * JD-Core Version:    0.6.0
 */