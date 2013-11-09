package com.flagleader.builder.a.b;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.d;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.tree.FunctionLibrary;
import java.util.Iterator;

public class w extends a
{
  public w(e parame)
  {
  }

  public void a()
  {
    if ((this.a.K() instanceof FunctionLibrary))
    {
      e.d(this.a);
    }
    else if (e.a(this.a) == 1)
    {
      IElement localIElement = e.b(this.a)[0];
      if ((localIElement instanceof IBusinessObjectEditen))
        e.b(this.a, (IBusinessObjectEditen)localIElement);
    }
  }

  public boolean b()
  {
    if (e.c(this.a))
      return false;
    if ((this.a.K() instanceof FunctionLibrary))
      return true;
    if (e.a(this.a) == 1)
    {
      IElement localIElement = e.b(this.a)[0];
      if ((localIElement instanceof IBusinessObjectEditen))
        return this.a.J().a(((IBusinessObjectEditen)localIElement).getJavaType()).hasNext();
    }
    return false;
  }

  public String c()
  {
    return "addTypeMethod";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.w
 * JD-Core Version:    0.6.0
 */