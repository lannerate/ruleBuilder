package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.e.s;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.action.AssignJudgeToken;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.action.TreeFunctionToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeFunction;
import com.flagleader.repository.xml.TreeValueNode;
import java.util.List;

public class m extends r
{
  public m(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof Rule)))
      return;
    Rule localRule = (Rule)paramITreeNode;
    localRule.getRuleElementToken().getThenActions();
    s locals = new s(this.a.getShell(), localRule.getEnvionment(), 2);
    if (locals.open() == 0)
    {
      List localList = locals.a();
      TreeValueNode localTreeValueNode = null;
      Object localObject1;
      Object localObject2;
      for (int i = localList.size() - 1; i >= 0; i--)
      {
        if (!(localList.get(i) instanceof TreeAttribute))
          continue;
        localObject1 = (TreeAttribute)localList.get(i);
        if ((((TreeAttribute)localObject1).getParent() != null) && ((((TreeAttribute)localObject1).getParent() instanceof TreeValueNode)))
          localTreeValueNode = (TreeValueNode)((TreeAttribute)localObject1).getParent();
        localObject2 = localRule.getEnvionment().getValueLibrary().getNoCaseEditen(((TreeAttribute)localObject1).getValueName(), ((TreeAttribute)localObject1).getDisplayName());
        if (localObject2 == null)
          localObject2 = localRule.getEnvionment().getTempVariableLibrary().getNoCaseEditen(((TreeAttribute)localObject1).getValueName(), ((TreeAttribute)localObject1).getDisplayName());
        if ((localObject2 == null) && (localRule.hasSheetWhile()))
        {
          localObject3 = localRule.getAllWhileSheets();
          for (int j = 0; j < ((List)localObject3).size(); j++)
          {
            localObject4 = (IWhileObject)((List)localObject3).get(j);
            localObject2 = ((IWhileObject)localObject4).getNoCaseEditen(((TreeAttribute)localObject1).getValueName(), ((TreeAttribute)localObject1).getDisplayName());
            if (localObject2 != null)
              break;
          }
        }
        Object localObject3 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject3, 0);
        AssignToken localAssignToken = new AssignToken();
        ((StatementContainerToken)localObject3).addChildElement(localAssignToken);
        Object localObject4 = new FieldToken();
        localAssignToken.addChildElement((IElement)localObject4);
        ((FieldToken)localObject4).setMemberElement((IElement)localObject1);
        localAssignToken.addChildElement(new AssignJudgeToken());
        MemberToken localMemberToken = new MemberToken(((TreeAttribute)localObject1).getValueType());
        localAssignToken.getComparedValue().addChildElement(localMemberToken);
        if (localObject2 != null)
          localMemberToken.setMemberElement((IElement)localObject2);
        localRule.setModified(true);
      }
      if ((localTreeValueNode != null) && (locals.c()))
      {
        TreeFunction localTreeFunction = localTreeValueNode.getTreeFunction("insert");
        if (localTreeFunction != null)
        {
          localObject1 = new TreeFunctionToken();
          localObject2 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2, 0);
          ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
          ((TreeFunctionToken)localObject1).setMemberElement(localTreeFunction);
          localRule.setModified(true);
        }
      }
      localRule.updateViewer();
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof Rule;
  }

  public String a()
  {
    return "LoadTreeValueSet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.m
 * JD-Core Version:    0.6.0
 */