package com.flagleader.repository.rlm.editen;

import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.util.TempID;

public class a
{
  private String a = null;
  private String b = null;
  private IBusinessObject c = null;

  public a(String paramString, IBusinessObject paramIBusinessObject)
  {
    this.b = paramString;
    this.c = paramIBusinessObject;
  }

  public String a()
  {
    return this.b;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public IBusinessObject b()
  {
    return this.c;
  }

  public void a(IBusinessObject paramIBusinessObject)
  {
    this.c = paramIBusinessObject;
  }

  public String c()
  {
    if (this.a == null)
      this.a = ("T" + TempID.newShortTempID());
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.editen.a
 * JD-Core Version:    0.6.0
 */