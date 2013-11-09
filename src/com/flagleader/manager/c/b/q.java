package com.flagleader.manager.c.b;

import com.flagleader.export.PagesMessages;
import com.flagleader.manager.c.c.e;
import com.flagleader.repository.tree.ExportModel;

class q
  implements e
{
  String[] a;

  q(p paramp, String paramString)
  {
    this.a = p.a(paramp).getPreferences().getStringArray(paramString + ".values");
  }

  public int a()
  {
    for (int i = 0; i < this.a.length; i++)
      if (this.a[i].equals(p.a(this.b).getPropertyValue(this.c)))
        return i;
    return -1;
  }

  public String[] b()
  {
    return p.a(this.b).getPreferences().getStringArray(this.c + ".disvalues");
  }

  public boolean a(int paramInt)
  {
    if (!this.a[paramInt].equals(p.a(this.b).getPropertyValue(this.c)))
    {
      p.a(this.b).setPropertyValue(this.c, this.a[paramInt]);
      p.a(this.b).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.b.q
 * JD-Core Version:    0.6.0
 */