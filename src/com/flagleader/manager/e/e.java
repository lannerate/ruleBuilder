package com.flagleader.manager.e;

import com.flagleader.manager.d.c;
import com.flagleader.repository.IElement;
import java.util.ArrayList;
import java.util.List;

public class e extends W
{
  List a = new ArrayList();

  public e(IElement paramIElement, boolean paramBoolean)
  {
    super(paramIElement);
    this.g = new f(this, paramIElement, paramBoolean);
  }

  public String a()
  {
    return c.b("CheckRuleThread.info");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.e
 * JD-Core Version:    0.6.0
 */