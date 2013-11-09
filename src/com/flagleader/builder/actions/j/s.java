package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.g.D;
import com.flagleader.builder.dialogs.g.i;
import com.flagleader.manager.a.a.j;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleTemplate;
import com.flagleader.util.ListUtil;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;

public class s extends x
{
  public s(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IPackageElement;
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
      i locali = new i(this.a.getShell(), localList1);
      if (locali.open() == 0)
      {
        List localList2 = locali.a();
        for (int i = 0; i < localList2.size(); i++)
        {
          if ((!(localList2.get(i) instanceof List)) || (((List)localList2.get(i)).size() <= 0))
            continue;
          try
          {
            j localj = this.a.getRulesManager().r();
            RuleTemplate localRuleTemplate = localj.a(NumberUtil.getInt(StringUtil.stringValue(((List)localList2.get(i)).get(0))));
            if (localRuleTemplate == null)
              continue;
            IRuleTree localIRuleTree = localRuleTemplate.getRule();
            paramITreeNode.addChildElement(localIRuleTree.deepClone());
            paramITreeNode.updateTree();
          }
          catch (Exception localException)
          {
            this.a.showError(localException.getMessage());
          }
        }
      }
    }
  }

  private List a(IPackageElement paramIPackageElement)
  {
    try
    {
      String str1 = "";
      String str2 = "";
      if ((paramIPackageElement instanceof IRuleTree))
        str1 = paramIPackageElement.toString();
      if (paramIPackageElement.getMainPackage() != null)
        str2 = paramIPackageElement.getMainPackage().getTemplateType();
      D localD = new D(this.a, str1, str2);
      if (localD.open() == 0)
      {
        j localj = this.a.getRulesManager().r();
        List localList = localj.a(localD.a(), localD.b());
        if (localList == null)
        {
          MessageDialog.openError(this.a.getShell(), "", localj.i());
          return ListUtil.EMPTYLIST;
        }
        return localList;
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return null;
  }

  public String a()
  {
    return "TemplateRuleLoad";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.s
 * JD-Core Version:    0.6.0
 */