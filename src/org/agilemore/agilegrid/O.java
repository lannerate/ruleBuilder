package org.agilemore.agilegrid;

import org.eclipse.swt.widgets.Event;

public class O
  implements am
{
  public boolean a(e parame, Event paramEvent)
  {
    switch (paramEvent.type)
    {
    case 1:
      switch (paramEvent.keyCode)
      {
      case 9:
      case 16777217:
      case 16777218:
      case 16777219:
      case 16777220:
      case 16777221:
      case 16777222:
      case 16777223:
      case 16777224:
        return true;
      }
      return false;
    case 3:
      G localG = parame.o(paramEvent.x, paramEvent.y);
      return (localG.c >= 0) && (localG.d >= 0);
    case 15:
      return true;
    }
    return false;
  }

  public G a(e parame, G paramG, Event paramEvent)
  {
    G localG = G.b;
    switch (paramEvent.type)
    {
    case 1:
      if (paramG == G.b)
        paramG = new G(parame, 0, 0);
      int i = paramG.c;
      int j = paramG.d;
      au localau = parame.w();
      switch (paramEvent.keyCode)
      {
      case 16777223:
        j = 0;
        localG = new G(parame, i, j);
        break;
      case 16777224:
        j = localau.b() - 1;
        if (i == -1)
          i = 0;
        localG = new G(parame, i, j);
        break;
      case 16777217:
        localG = parame.a(paramG, 1, true);
        break;
      case 16777218:
        localG = parame.a(paramG, 2, true);
        break;
      case 16777219:
        localG = parame.a(paramG, 4, true);
        break;
      case 16777220:
        localG = parame.a(paramG, 8, true);
        break;
      case 16777222:
        i += parame.s() - 1;
        if (i >= localau.a())
          i = localau.a() - 1;
        if (j == -1)
          j = 0;
        localG = new G(parame, i, j);
        break;
      case 16777221:
        i -= parame.s() - 1;
        if ((paramG.c == localau.i()) && (i < 0))
          i = 0;
        else if ((i < localau.i()) && (paramG.c != 0))
          i = localau.i();
        if (j == -1)
          j = localau.h();
        localG = new G(parame, i, j);
        break;
      case 9:
        int k = (paramEvent.stateMask & 0x20000) != 0 ? 4 : 8;
        localG = parame.a(paramG, k, true);
      }
      break;
    case 3:
      if (paramEvent.button != 1)
        break;
      localG = parame.o(paramEvent.x, paramEvent.y);
      if ((localG.c != -1) && (localG.d != -1))
        break;
      localG = G.b;
      break;
    case 15:
      if (paramG == G.b)
        localG = new G(parame, 0, 0);
      else
        localG = paramG;
    }
    return localG;
  }

  public boolean b(e parame, Event paramEvent)
  {
    switch (paramEvent.type)
    {
    case 1:
      switch (paramEvent.keyCode)
      {
      case 9:
      case 16777217:
      case 16777218:
      case 16777219:
      case 16777220:
      case 16777221:
      case 16777222:
      case 16777223:
      case 16777224:
        return true;
      }
      return false;
    case 3:
      return true;
    case 15:
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.O
 * JD-Core Version:    0.6.0
 */