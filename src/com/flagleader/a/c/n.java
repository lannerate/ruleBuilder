package com.flagleader.a.c;

import com.flagleader.a.B;
import com.flagleader.a.J;
import com.flagleader.a.K;
import com.flagleader.a.P;
import com.flagleader.a.S;
import com.flagleader.a.T;
import com.flagleader.a.U;
import com.flagleader.a.al;
import com.flagleader.a.l;
import com.flagleader.a.y;

public class n
{
  public static final K a = new p();
  public static final K b = new v();
  public static final K c = new w();
  public static final K d = new r();
  public static final K e = new s();

  public static boolean a(K paramK, S paramS)
  {
    if ((paramS instanceof B))
      return paramK.a((B)paramS);
    if ((paramS instanceof P))
      return paramK.a((P)paramS);
    if ((paramS instanceof y))
      return paramK.a((y)paramS);
    return false;
  }

  public static K a(K paramK1, K paramK2)
  {
    return new q(paramK1, paramK2);
  }

  public static S a(T paramT, K paramK)
  {
    return b(paramT, paramK).d();
  }

  public static S a(U paramU, K paramK)
  {
    if (paramU != null)
      return a(paramU.d(), paramK);
    return null;
  }

  public static K a(K paramK)
  {
    return new t(paramK);
  }

  public static K b(K paramK1, K paramK2)
  {
    return new u(paramK1, paramK2);
  }

  public static T b(T paramT, K paramK)
  {
    if (paramT != null)
    {
      o localo = new o(paramT, paramK);
      return new l(localo);
    }
    return new l();
  }

  public static T b(U paramU, K paramK)
  {
    if (paramU != null)
      return b(paramU.d(), paramK);
    return new l();
  }

  public static al a(J paramJ)
  {
    return a(new com.flagleader.a.w(paramJ.b()));
  }

  public static al a(al paramal)
  {
    return new com.flagleader.a.w(b(paramal, e));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.c.n
 * JD-Core Version:    0.6.0
 */