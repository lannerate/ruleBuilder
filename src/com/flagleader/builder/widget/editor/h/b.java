package com.flagleader.builder.widget.editor.h;

import com.flagleader.a.B;
import com.flagleader.a.K;
import com.flagleader.a.P;
import com.flagleader.a.y;
import java.lang.reflect.Method;

public class b
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
    if (paramP.p())
      return false;
    if ((paramP.f() != null) && (paramP.f().getDeclaringClass() != null))
      return paramP.l();
    return paramP.l();
  }

  public b(a parama)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.h.b
 * JD-Core Version:    0.6.0
 */