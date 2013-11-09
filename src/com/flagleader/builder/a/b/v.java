package com.flagleader.builder.a.b;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rom.IBusinessObjectEditen;

public class v extends a
{
  public v(e parame)
  {
  }

  public void a()
  {
    if (e.a(this.a) == 1)
    {
      IElement localIElement = e.b(this.a)[0];
      if (((localIElement instanceof IBusinessObjectEditen)) && (((IBusinessObjectEditen)localIElement).canCreateSubFunction()))
        e.a(this.a, (IBusinessObjectEditen)localIElement);
    }
  }

  public boolean b()
  {
    if (e.c(this.a))
      return false;
    if (e.a(this.a) == 1)
    {
      IElement localIElement = e.b(this.a)[0];
      if ((localIElement instanceof IBusinessObjectEditen))
        return ((IBusinessObjectEditen)localIElement).canCreateSubFunction();
    }
    return false;
  }

  public String c()
  {
    return "addSubFunc";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.v
 * JD-Core Version:    0.6.0
 */