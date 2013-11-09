package com.flagleader.repository.tree;

import com.flagleader.a.B;
import com.flagleader.a.K;
import com.flagleader.a.P;
import com.flagleader.a.y;

public class ak
  implements K
{
  public boolean a(y paramy)
  {
    int i = 0;
    if (paramy.l())
      i = 1;
    if (paramy.m())
      i = 0;
    return i;
  }

  public boolean a(B paramB)
  {
    return false;
  }

  public boolean a(P paramP)
  {
    return (paramP.l()) && (!paramP.p());
  }

  public ak(Envionment paramEnvionment)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.ak
 * JD-Core Version:    0.6.0
 */