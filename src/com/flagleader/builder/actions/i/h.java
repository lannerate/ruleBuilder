package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.aq;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.f.b;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class h extends bl
{
  public h(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "FindObjectItem";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return true;
  }

  public void b(ITreeNode paramITreeNode)
  {
    b localb = new b(paramITreeNode);
    if (localb.open() == 0)
    {
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      Iterator localIterator = localb.h().getAcceptElements(new i(this, localb));
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
 * Qualified Name:     com.flagleader.builder.actions.i.h
 * JD-Core Version:    0.6.0
 */