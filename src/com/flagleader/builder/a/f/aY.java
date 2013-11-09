package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.b.G;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.RuleFlowActivitie;
import com.flagleader.repository.tree.RuleFlowTransition;
import com.flagleader.repository.tree.RuleSetFlow;
import com.flagleader.util.StringUtil;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.TitleEvent;
import org.eclipse.swt.browser.TitleListener;

class aY
  implements TitleListener
{
  aY(aX paramaX)
  {
  }

  public void changed(TitleEvent paramTitleEvent)
  {
    String str = paramTitleEvent.title;
    if (str.equals(aX.b(this.a)))
      return;
    aX.a(this.a, str);
    if (str.startsWith("update"))
    {
      aX.c(this.a).execute("setXml('" + aX.d(this.a).getDisplayName() + "','" + aX.d(this.a).getFlowXml().replace('\n', ' ').replace('\r', ' ') + "');");
    }
    else
    {
      if (aX.d(this.a).isLocked())
      {
        aX.a(this.a, true);
        return;
      }
      Object localObject1;
      if (str.startsWith("addNode:"))
      {
        localObject1 = str.substring(8).split(";");
        RuleFlowActivitie localRuleFlowActivitie = aX.d(this.a).addNode(localObject1[2], Integer.parseInt(localObject1[0]), Integer.parseInt(localObject1[1]));
        if (localRuleFlowActivitie.getRuleUuid().length() > 0)
          aX.c(this.a).execute("xiorkFlow.getWrapper().getModel().setAddMetaNodeModel('" + localObject1[2] + "'," + localObject1[0] + "," + localObject1[1] + ",'" + localRuleFlowActivitie.getRuleUuid() + "','" + localRuleFlowActivitie.getDisplayName() + "')");
        else
          aX.c(this.a).execute("xiorkFlow.getWrapper().getModel().setAddMetaNodeModel('" + localObject1[2] + "'," + localObject1[0] + "," + localObject1[1] + ",'" + localRuleFlowActivitie.getUuid() + "','" + localRuleFlowActivitie.getDisplayName() + "')");
        aX.d(this.a).setModified(true);
      }
      else
      {
        Object localObject3;
        if (str.startsWith("removeNode:"))
        {
          localObject1 = str.substring(11).split(";");
          for (int i = 0; i < localObject1.length; i++)
          {
            localObject3 = aX.d(this.a).getFlowElement(localObject1[i]);
            if (localObject3 == null)
              continue;
            if ((localObject3 instanceof RuleFlowActivitie))
            {
              if (!aX.d(this.a).removeNode(localObject1[i]))
                continue;
              aX.c(this.a).execute("xiorkFlow.getWrapper().getModel().removeMetaNodeModel('" + localObject1[i] + "')");
            }
            else
            {
              if ((!(localObject3 instanceof RuleFlowTransition)) || (!aX.d(this.a).removeTrans(localObject1[i])))
                continue;
              aX.c(this.a).execute("xiorkFlow.getWrapper().getModel().removeTransitionID('" + localObject1[i] + "')");
            }
          }
          aX.d(this.a).setModified(true);
        }
        else if (str.startsWith("changeNode:"))
        {
          localObject1 = str.substring(11);
          aX.e(this.a).getProjectTree().c((String)localObject1);
        }
        else
        {
          Object localObject2;
          Object localObject4;
          if (str.startsWith("changeTrans:"))
          {
            localObject1 = str.substring(12);
            localObject2 = aX.d(this.a).getFlowElement((String)localObject1);
            if ((localObject2 != null) && ((localObject2 instanceof RuleFlowTransition)))
            {
              localObject3 = new G(aX.e(this.a).getShell(), aX.e(this.a), (RuleFlowTransition)localObject2);
              if (((G)localObject3).open() == 0)
              {
                localObject4 = ((RuleFlowTransition)localObject2).getInfo();
                aX.c(this.a).execute("xiorkFlow.getWrapper().getModel().setChangeTransitionModel('" + (String)localObject1 + "','" + StringUtil.replace(StringUtil.newline, "\\n", (String)localObject4) + "')");
                aX.d(this.a).setModified(true);
              }
            }
            aX.a(this.a, "");
          }
          else if (str.startsWith("addTrans:"))
          {
            localObject1 = str.substring(9).split(";");
            localObject2 = aX.d(this.a).addTrans(localObject1[0], localObject1[1]);
            if (localObject2 != null)
              aX.c(this.a).execute("xiorkFlow.getWrapper().getModel().setAddTransitionModel('" + localObject1[0] + "','" + localObject1[1] + "','" + ((IElement)localObject2).getUuid() + "')");
            aX.d(this.a).setModified(true);
          }
          else if (str.startsWith("removeTrans:"))
          {
            localObject1 = str.substring(12);
            aX.d(this.a).removeTrans((String)localObject1);
            aX.d(this.a).setModified(true);
          }
          else if (str.startsWith("nodeSize:"))
          {
            localObject1 = str.substring(9).split(";");
            localObject2 = aX.d(this.a).getFlowElement(localObject1[2]);
            if ((localObject2 != null) && ((localObject2 instanceof RuleFlowActivitie)))
            {
              ((RuleFlowActivitie)localObject2).setWidth(Integer.parseInt(localObject1[0]));
              ((RuleFlowActivitie)localObject2).setHeight(Integer.parseInt(localObject1[1]));
            }
            aX.d(this.a).setModified(true);
          }
          else if (str.startsWith("nodeMove:"))
          {
            localObject1 = str.substring(9).split(":");
            for (int j = 0; j < localObject1.length; j++)
            {
              localObject3 = localObject1[j].split(";");
              if (localObject3.length <= 2)
                continue;
              localObject4 = aX.d(this.a).getFlowElement(localObject3[2]);
              if ((localObject4 == null) || (!(localObject4 instanceof RuleFlowActivitie)))
                continue;
              ((RuleFlowActivitie)localObject4).setX(Integer.parseInt(localObject3[0]));
              ((RuleFlowActivitie)localObject4).setY(Integer.parseInt(localObject3[1]));
            }
            aX.d(this.a).setModified(true);
          }
        }
      }
    }
    aX.a(this.a, true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aY
 * JD-Core Version:    0.6.0
 */