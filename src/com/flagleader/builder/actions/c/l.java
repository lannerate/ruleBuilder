package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.e.s;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.action.AssignJudgeToken;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import java.util.List;

public class l extends r
{
  public l(BuilderManager paramBuilderManager)
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
      for (int i = localList.size() - 1; i >= 0; i--)
      {
        if (!(localList.get(i) instanceof TreeAttribute))
          continue;
        TreeAttribute localTreeAttribute = (TreeAttribute)localList.get(i);
        if ((localTreeAttribute.getParent() != null) && ((localTreeAttribute.getParent() instanceof TreeValueNode)))
          localTreeValueNode = (TreeValueNode)localTreeAttribute.getParent();
        IBusinessObjectEditen localIBusinessObjectEditen = localRule.getEnvionment().getValueLibrary().getNoCaseEditen(localTreeAttribute.getValueName(), localTreeAttribute.getDisplayName());
        if (localIBusinessObjectEditen == null)
          localIBusinessObjectEditen = localRule.getEnvionment().getTempVariableLibrary().getNoCaseEditen(localTreeAttribute.getValueName(), localTreeAttribute.getDisplayName());
        if ((localIBusinessObjectEditen == null) && (localRule.hasSheetWhile()))
        {
          localObject1 = localRule.getAllWhileSheets();
          for (int j = 0; j < ((List)localObject1).size(); j++)
          {
            localObject2 = (IWhileObject)((List)localObject1).get(j);
            localIBusinessObjectEditen = ((IWhileObject)localObject2).getNoCaseEditen(localTreeAttribute.getValueName(), localTreeAttribute.getDisplayName());
            if (localIBusinessObjectEditen != null)
              break;
          }
        }
        if (localTreeAttribute == null)
          continue;
        Object localObject1 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject1, 0);
        AssignToken localAssignToken = new AssignToken();
        ((StatementContainerToken)localObject1).addChildElement(localAssignToken);
        Object localObject2 = new FieldToken();
        localAssignToken.addChildElement((IElement)localObject2);
        localAssignToken.addChildElement(new AssignJudgeToken());
        if (localIBusinessObjectEditen != null)
          ((FieldToken)localObject2).setMemberElement(localIBusinessObjectEditen);
        else
          localAssignToken.changeFieldType(localTreeAttribute.getJavaType());
        MemberToken localMemberToken = new MemberToken(localTreeAttribute.getValueType());
        localAssignToken.getComparedValue().addChildElement(localMemberToken);
        if (localTreeAttribute != null)
          localMemberToken.setMemberElement(localTreeAttribute);
        localRule.setModified(true);
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
    return "LoadTreeValueGet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.l
 * JD-Core Version:    0.6.0
 */