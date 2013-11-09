package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.a.a.h;
import com.flagleader.manager.d.c;
import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.tree.ChildNodeInfo;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.ParentInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class o extends x
{
  public o(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IPackageElement;
  }

  private void a(ChildNodeInfo paramChildNodeInfo, ITreeNode paramITreeNode, String paramString)
  {
    ParentInfo localParentInfo = this.a.getRulesManager().s().a(paramString, h.a(paramITreeNode), paramChildNodeInfo.getDisplayName(), paramChildNodeInfo.getNametype());
    ITreeNode localITreeNode = (ITreeNode)localParentInfo.getElements();
    paramITreeNode.addChildElement(localITreeNode);
    List localList = localParentInfo.getChildNodeInfos();
    for (int i = 0; i < localList.size(); i++)
    {
      ChildNodeInfo localChildNodeInfo = (ChildNodeInfo)localList.get(i);
      a(localChildNodeInfo, localITreeNode, paramString);
    }
    localITreeNode.selfsave(false);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!(paramITreeNode instanceof IPackageElement))
      return;
    if (!e())
      return;
    List localList1 = a((IPackageElement)paramITreeNode);
    if (localList1 != null)
    {
      com.flagleader.builder.dialogs.g.r localr = new com.flagleader.builder.dialogs.g.r(this.a, localList1, paramITreeNode);
      if (localr.open() == 0)
      {
        List localList2 = localr.a();
        HashMap localHashMap = localr.b();
        this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
        for (int i = 0; i < localList2.size(); i++)
        {
          if ((!(localList2.get(i) instanceof ITreeNode)) || (localHashMap.get(localList2.get(i)) == null))
            continue;
          try
          {
            ITreeNode localITreeNode1 = (ITreeNode)localList2.get(i);
            List localList3 = (List)localHashMap.get(localList2.get(i));
            String str1 = (String)localList3.get(1);
            String str2 = (String)localList3.get(2);
            String str3 = (String)localList3.get(3);
            String str4 = (String)localList3.get(4);
            ParentInfo localParentInfo = this.a.getRulesManager().s().a(str1, str2, str3, str4);
            ITreeNode localITreeNode2 = (ITreeNode)localParentInfo.getElements();
            ITreeNode localITreeNode3 = (ITreeNode)localITreeNode1.getParent();
            int j = ((AbstractElement)localITreeNode3).indexOfElement(localITreeNode1);
            localITreeNode1.dispose();
            localITreeNode3.addChildElement(localITreeNode2, j);
            List localList4 = localParentInfo.getChildNodeInfos();
            for (int k = 0; k < localList4.size(); k++)
            {
              ChildNodeInfo localChildNodeInfo = (ChildNodeInfo)localList4.get(k);
              a(localChildNodeInfo, localITreeNode2, str1);
            }
            localITreeNode2.selfsave(false);
            localITreeNode3.setModified(true);
            localITreeNode3.updateTree();
          }
          catch (Exception localException)
          {
            this.a.showError(c.a("error.checkout", new String[] { localException.getMessage() }));
          }
        }
        this.a.getShell().setCursor(null);
      }
    }
  }

  private List a(IPackageElement paramIPackageElement)
  {
    try
    {
      String str1 = "";
      String str2 = "";
      if (!(paramIPackageElement instanceof IRulePackage))
        str1 = paramIPackageElement.getSrcPath();
      if (paramIPackageElement.getMainPackage() != null)
        str2 = paramIPackageElement.getMainPackage().getExeRulePackageName();
      else if (paramIPackageElement.getEnvionment() != null)
        str2 = paramIPackageElement.getEnvionment().getDisplayName();
      h localh = this.a.getRulesManager().s();
      List localList = localh.a(str2, h.a(paramIPackageElement.getParent()));
      if (localList == null)
      {
        MessageDialog.openError(this.a.getShell(), "", localh.i());
        return Collections.EMPTY_LIST;
      }
      return localList;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public String a()
  {
    return "NodeRuleLoad";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.o
 * JD-Core Version:    0.6.0
 */