package com.flagleader.manager.c.b;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.export.AjaxPage;

public class l
  implements f
{
  public l(a parama)
  {
  }

  public String a()
  {
    return a.a(this.a).getExportFile();
  }

  public boolean a(String paramString)
  {
    if (!a.a(this.a).getExportFile().equals(paramString))
    {
      a.a(this.a).setExportFile(paramString.toString());
      a.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.b.l
 * JD-Core Version:    0.6.0
 */