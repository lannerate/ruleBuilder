package com.flagleader.repository.rom;

import com.flagleader.a.B;
import com.flagleader.a.K;
import com.flagleader.a.P;
import com.flagleader.a.y;
import java.lang.reflect.Method;

public class a
  implements K
{
  public boolean a(y paramy)
  {
    int i = 0;
    if (paramy.l())
      i = 1;
    if (paramy.m())
      i = 0;
    if (!paramy.h().equals(BusinessObjectClass.access$0(this.a)))
      return false;
    return i;
  }

  public boolean a(B paramB)
  {
    return false;
  }

  public boolean a(P paramP)
  {
    if ((paramP.f() != null) && (paramP.f().getDeclaringClass() != null))
      return (paramP.l()) && (paramP.f().getDeclaringClass().getName().equals(BusinessObjectClass.access$0(this.a).K()));
    return paramP.l();
  }

  public a(BusinessObjectClass paramBusinessObjectClass)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.a
 * JD-Core Version:    0.6.0
 */