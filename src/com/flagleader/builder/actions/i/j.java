package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.aq;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.f.c;
import com.flagleader.repository.rlm.IRuleObject;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class j extends bl
{
  public j(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "FindRuleItem";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return true;
  }

  public void b(ITreeNode paramITreeNode)
  {
    c localc = new c(paramITreeNode);
    if (localc.open() == 0)
    {
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      Iterator localIterator = localc.j().getAcceptElements(new k(this, localc));
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof IRuleObject))
          continue;
        IPackageElement localIPackageElement = ((IRuleObject)localObject).getRoot().getRuleTree();
        if (localHashMap.get(localIPackageElement) != null)
          continue;
        localArrayList.add(localIPackageElement);
        localHashMap.put(localIPackageElement, localIPackageElement);
      }
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
 * Qualified Name:     com.flagleader.builder.actions.i.j
 * JD-Core Version:    0.6.0
 */