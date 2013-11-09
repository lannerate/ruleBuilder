package com.flagleader.manager.c.b;

import com.flagleader.export.PagesMessages;
import com.flagleader.manager.c.c.e;
import com.flagleader.repository.export.AjaxPage;

class b
  implements e
{
  String[] a;

  b(a parama, String paramString)
  {
    this.a = a.a(parama).getPreferences().getStringArray(paramString + ".values");
  }

  public int a()
  {
    for (int i = 0; i < this.a.length; i++)
      if (this.a[i].equals(a.a(this.b).getPropertyValue(this.c)))
        return i;
    return -1;
  }

  public String[] b()
  {
    return a.a(this.b).getPreferences().getStringArray(this.c + ".disvalues");
  }

  public boolean a(int paramInt)
  {
    if (!this.a[paramInt].equals(a.a(this.b).getPropertyValue(this.c)))
    {
      a.a(this.b).setPropertyValue(this.c, this.a[paramInt]);
      a.a(this.b).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.b.b
 * JD-Core Version:    0.6.0
 */