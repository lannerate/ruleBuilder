package com.flagleader.manager.c.b;

import com.flagleader.manager.builder.b;
import com.flagleader.manager.c.c.e;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.ExportModel;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.IOException;

public class B
  implements e
{
  public B(p paramp)
  {
  }

  public int a()
  {
    for (int i = 0; i < p.b(this.a).length; i++)
      if (p.b(this.a)[i].equals(p.a(this.a).getImportFile()))
        return i;
    return -1;
  }

  public String[] b()
  {
    return p.c(this.a);
  }

  public boolean a(int paramInt)
  {
    String str = p.b(this.a)[paramInt];
    if (!p.a(this.a).getImportFile().equals(str))
    {
      if (p.a(this.a).getModelStr().length() == 0)
      {
        p.a(this.a).setImportFile(str);
      }
      else
      {
        p.a(this.a).setImportFile(str);
        try
        {
          p.a(this.a).setModelStr(FileUtil.readFromFile(new File(str)));
        }
        catch (IOException localIOException)
        {
        }
      }
      p.a(this.a).setModified(true);
      p.d(this.a).b().gotoTreeNode(p.a(this.a));
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.b.B
 * JD-Core Version:    0.6.0
 */