package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.widget.d;
import com.flagleader.manager.r;
import com.flagleader.repository.IElement;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.flow.RulePoolNode;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.graphics.Point;

class bw
  implements DropTargetListener
{
  bw(bu parambu)
  {
  }

  public void dragEnter(DropTargetEvent paramDropTargetEvent)
  {
    if (paramDropTargetEvent.detail == 16)
      paramDropTargetEvent.detail = 2;
  }

  public void dragOperationChanged(DropTargetEvent paramDropTargetEvent)
  {
    if (paramDropTargetEvent.detail == 16)
      paramDropTargetEvent.detail = 2;
  }

  public void dragOver(DropTargetEvent paramDropTargetEvent)
  {
    paramDropTargetEvent.feedback = 17;
  }

  public void drop(DropTargetEvent paramDropTargetEvent)
  {
    Object localObject1;
    Object localObject2;
    if (TextTransfer.getInstance().isSupportedType(paramDropTargetEvent.currentDataType))
    {
      localObject1 = (String)paramDropTargetEvent.data;
      localObject2 = bu.d(this.a).getRulesManager().d().findNode((String)localObject1);
      if ((localObject2 != null) && (paramDropTargetEvent.item == null))
      {
        RulePoolNode localRulePoolNode;
        if ((localObject2 instanceof IRulePackage))
        {
          localRulePoolNode = bu.c(this.a).addFlowActivitie(((IRulePackage)localObject2).getUuid(), "RULEPACKAGE", paramDropTargetEvent.x - bu.a(bu.b(this.a)).x - 10, paramDropTargetEvent.y - bu.a(bu.b(this.a)).y - 30);
          localRulePoolNode.setExeRuleName(((IRulePackage)localObject2).getExeRulePackageName());
          localRulePoolNode.setExeRuleDisplay(((IRulePackage)localObject2).getDisplayName());
          bu.a(this.a, localRulePoolNode);
          bu.c(this.a).setModified(true);
        }
        else if (((localObject2 instanceof IRuleTree)) && (((IRuleTree)localObject2).getMainPackage() != null))
        {
          localRulePoolNode = bu.c(this.a).addFlowActivitie(((IRuleTree)localObject2).getUuid(), RulePoolNode.getElementState((IElement)localObject2), paramDropTargetEvent.x - bu.a(bu.b(this.a)).x - 10, paramDropTargetEvent.y - bu.a(bu.b(this.a)).y - 60);
          if (!((IRuleTree)localObject2).getMainPackage().equals(bu.c(this.a).getMainPackage()))
            localRulePoolNode.setExeRuleName(((IRuleTree)localObject2).getMainPackage().getExeRulePackageName() + ((IRuleTree)localObject2).getVisitRuleName());
          localRulePoolNode.setExeRuleDisplay(((IRuleTree)localObject2).getDisplayName());
          bu.a(this.a, localRulePoolNode);
          bu.c(this.a).setModified(true);
        }
      }
    }
    else if (d.a().isSupportedType(paramDropTargetEvent.currentDataType))
    {
      localObject1 = (ITreeNode)paramDropTargetEvent.data;
      if (paramDropTargetEvent.item == null)
        if ((localObject1 instanceof IRulePackage))
        {
          localObject2 = bu.c(this.a).addFlowActivitie(((IRulePackage)localObject1).getUuid(), "RULEPACKAGE", paramDropTargetEvent.x - bu.a(bu.b(this.a)).x - 10, paramDropTargetEvent.y - bu.a(bu.b(this.a)).y - 30);
          ((RulePoolNode)localObject2).setExeRuleName(((IRulePackage)localObject1).getExeRulePackageName());
          ((RulePoolNode)localObject2).setExeRuleDisplay(((IRulePackage)localObject1).getDisplayName());
          bu.a(this.a, (RulePoolNode)localObject2);
          bu.c(this.a).setModified(true);
        }
        else if ((localObject1 instanceof IRuleTree))
        {
          localObject2 = bu.c(this.a).addFlowActivitie(((IRuleTree)localObject1).getUuid(), RulePoolNode.getElementState((IElement)localObject1), paramDropTargetEvent.x - bu.a(bu.b(this.a)).x - 10, paramDropTargetEvent.y - bu.a(bu.b(this.a)).y - 30);
          ((RulePoolNode)localObject2).setExeRuleDisplay(((IRuleTree)localObject1).getDisplayName());
          bu.a(this.a, (RulePoolNode)localObject2);
          bu.c(this.a).setModified(true);
        }
    }
  }

  public void dragLeave(DropTargetEvent paramDropTargetEvent)
  {
  }

  public void dropAccept(DropTargetEvent paramDropTargetEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bw
 * JD-Core Version:    0.6.0
 */