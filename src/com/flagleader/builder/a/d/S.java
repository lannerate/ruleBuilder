package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.f;
import com.flagleader.repository.IElement;
import com.flagleader.repository.export.IPage;

class S
  implements f
{
  S(P paramP, IElement paramIElement)
  {
  }

  public String a()
  {
    return this.b.getDisplayName();
  }

  public boolean a(String paramString)
  {
    if (!this.b.getDisplayName().equals(paramString))
    {
      this.b.setDisplayName(paramString);
      this.a.q().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.S
 * JD-Core Version:    0.6.0
 */