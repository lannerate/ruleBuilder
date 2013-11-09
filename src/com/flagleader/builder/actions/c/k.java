package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.e.o;
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
import com.flagleader.repository.soap.SoapParameter;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import java.util.List;

public class k extends r
{
  public k(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof Rule)))
      return;
    Rule localRule = (Rule)paramITreeNode;
    localRule.getRuleElementToken().getThenActions();
    o localo = new o(this.a.getShell(), localRule.getEnvionment(), 1);
    if (localo.open() == 0)
    {
      List localList = localo.a();
      SoapService localSoapService = null;
      for (int i = localList.size() - 1; i >= 0; i--)
      {
        if (!(localList.get(i) instanceof SoapParameter))
          continue;
        SoapParameter localSoapParameter = (SoapParameter)localList.get(i);
        if ((localSoapParameter.getParent() != null) && ((localSoapParameter.getParent() instanceof SoapService)))
          localSoapService = (SoapService)localSoapParameter.getParent();
        IBusinessObjectEditen localIBusinessObjectEditen = localRule.getEnvionment().getValueLibrary().getNoCaseEditen(localSoapParameter.getValueName(), localSoapParameter.getDisplayName());
        if (localIBusinessObjectEditen == null)
          localIBusinessObjectEditen = localRule.getEnvionment().getTempVariableLibrary().getNoCaseEditen(localSoapParameter.getValueName(), localSoapParameter.getDisplayName());
        if ((localIBusinessObjectEditen == null) && (localRule.hasSheetWhile()))
        {
          localObject1 = localRule.getAllWhileSheets();
          for (int j = 0; j < ((List)localObject1).size(); j++)
          {
            localObject2 = (IWhileObject)((List)localObject1).get(j);
            localIBusinessObjectEditen = ((IWhileObject)localObject2).getNoCaseEditen(localSoapParameter.getValueName(), localSoapParameter.getDisplayName());
            if (localIBusinessObjectEditen != null)
              break;
          }
        }
        Object localObject1 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject1, 0);
        AssignToken localAssignToken = new AssignToken();
        ((StatementContainerToken)localObject1).addChildElement(localAssignToken);
        Object localObject2 = new FieldToken();
        localAssignToken.addChildElement((IElement)localObject2);
        ((FieldToken)localObject2).setMemberElement(localSoapParameter);
        localAssignToken.addChildElement(new AssignJudgeToken());
        MemberToken localMemberToken = new MemberToken(localSoapParameter.getValueType());
        localAssignToken.getComparedValue().addChildElement(localMemberToken);
        if (localIBusinessObjectEditen != null)
          localMemberToken.setMemberElement(localIBusinessObjectEditen);
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
    return "LoadSoapParameterSet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.k
 * JD-Core Version:    0.6.0
 */