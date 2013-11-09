package com.flagleader.manager.c.b;

import com.flagleader.export.PagesMessages;
import com.flagleader.manager.builder.b;
import com.flagleader.manager.c.c.e;
import com.flagleader.manager.r;
import com.flagleader.repository.export.AjaxPage;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.IOException;

public class m
  implements e
{
  private String[] b;
  private String[] c;

  public m(a parama)
  {
    this.b = a.a(parama).getPreferences().getAdditionalStringArray("rspTemplates.choise");
    this.c = null;
  }

  public int a()
  {
    for (int i = 0; i < this.b.length; i++)
      if (this.b[i].equals(a.a(this.a).getImportFile()))
        return i;
    return -1;
  }

  public String[] b()
  {
    this.c = new String[this.b.length];
    for (int i = 0; i < this.b.length; i++)
      this.c[i] = a.a(this.a).getPreferences().getString(this.b[i] + ".name", this.b[i]);
    if ((this.c == null) || (this.c.length != this.b.length))
      this.c = this.b;
    return this.c;
  }

  public boolean a(int paramInt)
  {
    String str = this.b[paramInt];
    if (!a.a(this.a).getImportFile().equals(str))
    {
      if (a.a(this.a).getModelStr().length() == 0)
      {
        a.a(this.a).setImportFile(str);
      }
      else
      {
        a.a(this.a).setImportFile(str);
        try
        {
          a.a(this.a).setModelStr(FileUtil.readFromFile(new File(str)));
        }
        catch (IOException localIOException)
        {
        }
      }
      a.a(this.a).setModified(true);
      a.b(this.a).b().gotoTreeNode(a.a(this.a));
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.b.m
 * JD-Core Version:    0.6.0
 */