package com.flagleader.builder.a.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.c.e;
import com.flagleader.manager.a;
import com.flagleader.manager.d.b;
import com.flagleader.manager.r;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.PageFieldModel;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.m;

class Y
  implements e
{
  Y(W paramW, PageFieldModel paramPageFieldModel)
  {
  }

  public boolean a(String paramString)
  {
    if (!this.b.getValueType().equals(paramString))
    {
      this.b.setValueType(paramString);
      W.a(this.b, paramString);
      this.a.q().setModified(true);
      if (W.c(this.a).getConfigManager().E())
        W.c(this.a).getRulesManager().c().a(this.a.q());
      return true;
    }
    return false;
  }

  public String[] a()
  {
    return m.a().g().a();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.Y
 * JD-Core Version:    0.6.0
 */