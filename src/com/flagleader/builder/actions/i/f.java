package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.aq;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.f.a;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class f extends bl
{
  public f(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "FindNodeItem";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return true;
  }

  public void b(ITreeNode paramITreeNode)
  {
    a locala = new a(paramITreeNode);
    if (locala.open() == 0)
    {
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      Iterator localIterator = locala.h().getAcceptElements(new g(this, locala));
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      while (localIterator.hasNext())
        localArrayList.add(localIterator.next());
      this.a.getMessageWindow().a(localArrayList);
      this.a.getShell().setCursor(null);
    }
  }

  private boolean a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      if (paramBoolean1)
        return StringUtil.equalsNoCase(paramString1, paramString2);
      return StringUtil.equalsCase(paramString1, paramString2);
    }
    if (paramBoolean1)
      return StringUtil.indexOfNoCase(paramString1, paramString2);
    return StringUtil.indexOf(paramString1, paramString2);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.f
 * JD-Core Version:    0.6.0
 */