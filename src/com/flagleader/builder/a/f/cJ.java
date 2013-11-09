package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.widget.d;
import com.flagleader.manager.r;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleFlowActivitie;
import com.flagleader.repository.tree.RuleTreeFlow;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.graphics.Point;

class cJ
  implements DropTargetListener
{
  cJ(cG paramcG)
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
      localObject2 = cG.e(this.a).getRulesManager().d().findNode((String)localObject1);
      if ((localObject2 != null) && (paramDropTargetEvent.item == null))
      {
        RuleFlowActivitie localRuleFlowActivitie;
        if ((localObject2 instanceof IRulePackage))
        {
          localRuleFlowActivitie = cG.c(this.a).addFlowActivitie(((IRulePackage)localObject2).getUuid(), "RULEPACKAGE", paramDropTargetEvent.x - cG.a(cG.b(this.a)).x - 10, paramDropTargetEvent.y - cG.a(cG.b(this.a)).y - 30);
          localRuleFlowActivitie.setExeRuleName(((IRulePackage)localObject2).getExeRulePackageName());
          localRuleFlowActivitie.setExeRuleDisplay(((IRulePackage)localObject2).getDisplayName());
          cG.a(this.a, localRuleFlowActivitie);
          cG.c(this.a).setModified(true);
        }
        else if (((localObject2 instanceof IRuleTree)) && (((IRuleTree)localObject2).getMainPackage() != null))
        {
          if (((IRuleTree)localObject2).getMainPackage().equals(cG.c(this.a).getMainPackage()))
          {
            localRuleFlowActivitie = cG.c(this.a).addFlowActivitie(((IRuleTree)localObject2).getUuid(), RuleFlowActivitie.getElementState((IElement)localObject2), paramDropTargetEvent.x - cG.a(cG.b(this.a)).x - 10, paramDropTargetEvent.y - cG.a(cG.b(this.a)).y - 60);
            localRuleFlowActivitie.setExeRuleDisplay(((IRuleTree)localObject2).getDisplayName());
            cG.a(this.a, localRuleFlowActivitie);
            cG.c(this.a).setModified(true);
          }
          else if (((IRuleTree)localObject2).supportVisitRule())
          {
            localRuleFlowActivitie = cG.c(this.a).addFlowActivitie(((IRuleTree)localObject2).getUuid(), RuleFlowActivitie.getElementState((IElement)localObject2), paramDropTargetEvent.x - cG.a(cG.b(this.a)).x - 10, paramDropTargetEvent.y - cG.a(cG.b(this.a)).y - 60);
            localRuleFlowActivitie.setExeRuleName(((IRuleTree)localObject2).getMainPackage().getExeRulePackageName() + ((IRuleTree)localObject2).getVisitRuleName());
            localRuleFlowActivitie.setExeRuleDisplay(((IRuleTree)localObject2).getDisplayName());
            cG.a(this.a, localRuleFlowActivitie);
            cG.c(this.a).setModified(true);
          }
        }
      }
    }
    else if (d.a().isSupportedType(paramDropTargetEvent.currentDataType))
    {
      localObject1 = (ITreeNode)paramDropTargetEvent.data;
      if (paramDropTargetEvent.item == null)
        if ((localObject1 instanceof IRulePackage))
        {
          localObject2 = cG.c(this.a).addFlowActivitie(((IRulePackage)localObject1).getUuid(), "RULEPACKAGE", paramDropTargetEvent.x - cG.a(cG.b(this.a)).x - 10, paramDropTargetEvent.y - cG.a(cG.b(this.a)).y - 30);
          ((RuleFlowActivitie)localObject2).setExeRuleName(((IRulePackage)localObject1).getExeRulePackageName());
          ((RuleFlowActivitie)localObject2).setExeRuleDisplay(((IRulePackage)localObject1).getDisplayName());
          cG.a(this.a, (RuleFlowActivitie)localObject2);
          cG.c(this.a).setModified(true);
        }
        else if ((localObject1 instanceof IRuleTree))
        {
          localObject2 = cG.c(this.a).addFlowActivitie(((IRuleTree)localObject1).getUuid(), RuleFlowActivitie.getElementState((IElement)localObject1), paramDropTargetEvent.x - cG.a(cG.b(this.a)).x - 10, paramDropTargetEvent.y - cG.a(cG.b(this.a)).y - 30);
          ((RuleFlowActivitie)localObject2).setExeRuleDisplay(((IRuleTree)localObject1).getDisplayName());
          cG.a(this.a, (RuleFlowActivitie)localObject2);
          cG.c(this.a).setModified(true);
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
 * Qualified Name:     com.flagleader.builder.a.f.cJ
 * JD-Core Version:    0.6.0
 */