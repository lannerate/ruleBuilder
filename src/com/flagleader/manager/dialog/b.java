package com.flagleader.manager.dialog;

import com.flagleader.manager.d.c;

public abstract class b
  implements IDialogInfo
{
  protected d a = null;

  public b(d paramd)
  {
    this.a = paramd;
    if (paramd != null)
      paramd.a(this);
  }

  public String a(String paramString)
  {
    return c.b(paramString);
  }

  public d getAfterFinish()
  {
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.dialog.b
 * JD-Core Version:    0.6.0
 */