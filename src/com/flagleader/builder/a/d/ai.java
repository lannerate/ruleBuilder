package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.IElement;
import com.flagleader.repository.export.PageFieldModel;
import org.eclipse.swt.widgets.Item;

public class ai extends a
{
  public ai(W paramW)
  {
  }

  public void a()
  {
    if (this.a.f() == 1)
    {
      Item localItem = this.a.i()[0];
      if ((localItem.getData() instanceof PageFieldModel))
        W.a(this.a, localItem);
    }
  }

  public boolean b()
  {
    if (W.b(this.a))
      return false;
    if (this.a.f() == 1)
    {
      IElement localIElement = this.a.g()[0];
      if ((localIElement instanceof PageFieldModel))
        return true;
    }
    return false;
  }

  public String c()
  {
    return "addSubFunc";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.ai
 * JD-Core Version:    0.6.0
 */