package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.e.b;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import java.util.Iterator;
import java.util.List;

public class c extends r
{
  List b;

  public c(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof RuleSet)))
      return;
    RuleSet localRuleSet = (RuleSet)paramITreeNode;
    b localb = new b(this.a.getShell(), localRuleSet.getEnvionment(), 2);
    if (localb.open() == 0)
    {
      this.b = localb.a();
      if ((this.b.size() > 0) && ((this.b.get(0) instanceof TreeValueNode)))
      {
        TreeValueNode localTreeValueNode = (TreeValueNode)this.b.get(0);
        ITreeNode localITreeNode = localRuleSet.createChildNode("RuleSet");
        if (localITreeNode != null)
        {
          localITreeNode.setDisplayName(localTreeValueNode.getDisplayName());
          localITreeNode.setModified(true);
          localTreeValueNode.setModified(true);
          a(localTreeValueNode, (RuleSet)localITreeNode);
        }
      }
      localRuleSet.updateTree();
    }
  }

  private boolean a(IElement paramIElement)
  {
    for (int i = 0; (this.b != null) && (i < this.b.size()); i++)
      if (this.b.get(i).equals(paramIElement))
        return true;
    return false;
  }

  private void a(TreeValueNode paramTreeValueNode, RuleSet paramRuleSet)
  {
    Iterator localIterator = paramTreeValueNode.getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      ITreeNode localITreeNode;
      if (((localObject instanceof TreeValueNode)) && (a((TreeValueNode)localObject)))
      {
        localITreeNode = paramRuleSet.createChildNode("RuleSet");
        if (localITreeNode == null)
          continue;
        localITreeNode.setDisplayName(((TreeValueNode)localObject).getDisplayName());
        localITreeNode.setModified(true);
        paramTreeValueNode.setModified(true);
        a((TreeValueNode)localObject, (RuleSet)localITreeNode);
      }
      else
      {
        if ((!(localObject instanceof TreeAttribute)) || (!a((TreeAttribute)localObject)))
          continue;
        localITreeNode = paramRuleSet.createChildNode("Rule");
        if (localITreeNode == null)
          continue;
        localITreeNode.setDisplayName(((TreeAttribute)localObject).getDisplayName());
        localITreeNode.setModified(true);
        paramTreeValueNode.setModified(true);
      }
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof RuleSet;
  }

  public String a()
  {
    return "AddTreeValueRules";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.c
 * JD-Core Version:    0.6.0
 */