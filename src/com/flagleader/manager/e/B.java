package com.flagleader.manager.e;

import com.flagleader.manager.d.c;
import com.flagleader.repository.tree.IPackageElement;
import java.util.List;

public class B extends W
{
  String a = null;

  public B(IPackageElement paramIPackageElement, String paramString, List paramList)
  {
    super(paramIPackageElement);
    this.a = paramString;
    this.g = new C(this, paramString, paramList);
  }

  public String b()
  {
    return super.b() + this.a;
  }

  public String a()
  {
    return c.b("ExportRuleExcelInfo.info");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.B
 * JD-Core Version:    0.6.0
 */